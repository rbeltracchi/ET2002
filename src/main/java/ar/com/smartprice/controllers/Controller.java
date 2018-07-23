package ar.com.smartprice.controllers;

import ar.com.smartprice.dtos.ArbolCategoriesDto;
import ar.com.smartprice.dtos.CredentialsDto;
import ar.com.smartprice.dtos.GmapsDto;
import ar.com.smartprice.dtos.ListadoDePreciosDto;
import ar.com.smartprice.dtos.ListadoDeProductDto;
import ar.com.smartprice.dtos.PrecioDto;
import ar.com.smartprice.dtos.ProductDto;
import ar.com.smartprice.dtos.SearchDto;
import ar.com.smartprice.dtos.UserDto;
import ar.com.smartprice.models.services.CategoriesService;
import ar.com.smartprice.models.services.PreciosService;
import ar.com.smartprice.models.services.SearchService;
import ar.com.smartprice.models.services.ProductService;
import ar.com.smartprice.models.services.UsersService;
import ar.com.smartprice.utils.ComparatorConDesempate;
import ar.com.smartprice.utils.ComparatorPorDistancia;
import ar.com.smartprice.utils.ComparatorPorPrecio;
import ar.com.smartprice.models.services.GmapService;
import ar.com.smartprice.views.MainWindowFrame;
import ar.com.smartprice.views.SearchPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 * @author Andres
 * @version 0.1.0
 *
 * Esta clase será la encargada de llamar a los servicios y entregar las
 * solicitudes a las vistas.
 */
public class Controller implements ActionListener, MouseListener {

    private UserDto user;
    private MainWindowFrame view;
    private GmapService gmaps = new GmapService();
    private UsersService userServices = new UsersService();
    private CategoriesService categorias = new CategoriesService();

    private ProductService productService = new ProductService();

    private ListadoDeProductDto productos;
    private ListadoDePreciosDto precios;
    private ListadoDePreciosDto preciosDelOferente;
    private String userLocation;
    private ProductDto productoSeleccionado = null;
    private PrecioDto precioSeleccionado;
    private boolean distanciasCalculadas = false;
    private ArbolCategoriesDto arbolCategorias;
    private boolean creandoPrecio;

    public Controller(MainWindowFrame view) {
        this.view = view;
        this.view.setVisible(true);
        this.listenObjects();
        user = new UserDto();
        //user.setUserType(1);
    }

    /**
     * @author Andres Este metodo realizara el login de los usuarios.
     */
    private void login() {

        if (this.view.loginPanel.userLoginTextField.getText().isEmpty() || String.valueOf(this.view.loginPanel.loginPassField.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(this.view, "Faltan campos requeridos");
            return;
        }
        CredentialsDto credentials = new CredentialsDto(this.view.loginPanel.userLoginTextField.getText(), String.valueOf(this.view.loginPanel.loginPassField.getPassword()));

        this.user = userServices.logIn(credentials);
        System.out.println("usuario " + this.user.toString());
        if (this.user.getError() != null) {
            System.out.println("Error " + this.user.getError().getMessage());
            JOptionPane.showMessageDialog(this.view, this.user.getError().getMessage());
            return;
        }

        if (!this.user.getToken().isEmpty() || this.user.getToken() != null) {
            switch (this.user.getUserType()) {
                case 2:
                    this.view.showUserLoggedPanel();
                    view.searchPanel.hideOpcionesOferente();
                    this.view.userLoggedPanel.lblusername.setText(user.getEmail());
                    this.view.profilePanel.txtEmail.setText(user.getEmail());
                    view.selectProductPanel.hideAddButtons();
                    break;
                case 3:
                    //TODO implementar el metodo en la vista.
                    this.view.showOffererLoggedPanel(user);
                    this.view.offererLoggedPanel.lblusername.setText(user.getName());
                    view.searchPanel.showOpcionesOferente();
                    view.selectProductPanel.showAddButtons();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private void signUser() {
        

        this.user = view.userSignInPanel.getData();
        if (user.getError() != null) {
            JOptionPane.showMessageDialog(this.view, user.getError().getMessage());
            return;
        }
        if (!userServices.create(this.user)) {
            //TODO mostrar error que viene del modelo UsersService
            JOptionPane.showMessageDialog(this.view, "No se pudo registrar el usuario");
            return;
        }

        this.view.userPanel.remove(this.view.userSignInPanel);
        this.view.showUserLoginPanel();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.user != null) {
            System.out.println(this.user.toString());
        }

        //boton login del panellogin
        if (e.getSource() == this.view.loginPanel.loginButton) {

            this.login();
        } else if (e.getSource() == this.view.loginPanel.signInButton) {
            System.out.println("boton registrarse");

            this.view.userPanel.remove(this.view.loginPanel);

            this.view.showUserSignPanel();

        } else if (e.getSource() == this.view.userSignInPanel.registerButton) {
            System.out.println("boton registracion");
            signUser();

        } else if (e.getSource() == this.view.userSignInPanel.cancelButton) {
            System.out.println("boton cancelar");
            this.view.userPanel.remove(this.view.userSignInPanel);
            this.view.showUserLoginPanel();
        } else if (e.getSource() == this.view.userLoggedPanel.btnProfile) {
            System.out.println("[UserLoggedPanel] boton profile");
            this.view.showProfilePanel(user);

        } else if (e.getSource() == this.view.userLoggedPanel.btnLogout) {
            System.out.println("[UserLoggedPanel] boton logout");
            this.user = UsersService.logOut(this.user);

            this.view.logout();

        } else if (e.getSource() == this.view.offererLoggedPanel.btnProfile) {
            System.out.println("[OffererLoggedPanel] boton profile");
            this.view.showProfilePanel(user);

        } else if (e.getSource() == this.view.offererLoggedPanel.btnLogout) {
            System.out.println("[OffererLoggedPanel] boton logout");
            this.user = UsersService.logOut(this.user);
            this.view.userSignInPanel.hideOffererFilds();
            this.view.searchPanel.hideOpcionesOferente();
            this.view.logout();

        } else if (e.getSource() == this.view.searchPanel.btnSearch) {
            distanciasCalculadas = false;
            this.buscarYActualizarPanelPrecios();

        } else if (e.getSource() == this.view.searchPanel.precio_only_radioButton
                || e.getSource() == this.view.searchPanel.precioDistanciaRadioButton
                || e.getSource() == this.view.searchPanel.distanciaPrecioRadioButton) {
            // CAMBIO DE BOTON DE SELECCION
            this.actualizarPanelPrecios();
        } else if (e.getSource() == this.view.profilePanel.btnDeleteAccount) {
            System.out.println("[ProfilePanel] boton borrar cuenta");

        } else if (e.getSource() == this.view.profilePanel.btnUpdateProfile) {
            System.out.println("[ProfilePanel] boton Actualizar perfil");

        } else if (e.getSource() == this.view.offererLoggedPanel.btnpreciosyprod) {
            this.view.resultPanel.removeAll();
            this.view.resultPanel.add(this.view.searchPanel);
            this.view.resultPanel.add(this.view.searchPanel);
            this.view.resultPanel.add(this.view.logoPanel);
            this.view.resultPanel.revalidate();
            this.view.resultPanel.repaint();
        } else if (e.getSource() == this.view.createProductPanel.btnCreateProduct) {
            ProductDto nuevo = view.createProductPanel.getProductDto();
            productService.insertarProducto(nuevo);
            this.view.dialogoCreateProduct.dispose();
            productos.addProducto(nuevo);
            this.view.showSelectProductPanel(productos);

        } else if (e.getSource() == this.view.selectProductPanel.btnAddProduct) {
            this.view.showCreateProductPanel(this.getArbol());
        } else if (e.getSource() == this.view.selectProductPanel.btnAddPrice) {
            PrecioDto nuevo = new PrecioDto();
            nuevo.setOferente(user);
            productoSeleccionado = view.selectProductPanel.getProductoSeleccionado();
            nuevo.setProducto(productoSeleccionado);
            creandoPrecio = true;//Aca abro el panel para crear
            this.view.showCreatePricePanel(nuevo, this, creandoPrecio);
        } else if (e.getSource() == this.view.createPricePanel.btnModificarPrecio) {
            System.out.println("ENTRO A PUBLICAR PRECIO NUEVO");
            PrecioDto nuevoPrecio = view.createPricePanel.getModificado();
            if (PreciosService.publicarPrecio(nuevoPrecio)) {
                JOptionPane.showMessageDialog(null, "Precio cargado correctamente");
                if (creandoPrecio) {
                    productoSeleccionado.getPrecios().addPrecio(nuevoPrecio);
                } else {
                    precioSeleccionado.copiar(nuevoPrecio);
                }
                view.selectProductPanel.actualizarPanelPrecios();
            }
            view.createPricePanel.cerrar();
        } else if (e.getSource() == view.searchPanel.chkMyPrices) {
            view.selectProductPanel.setRestriccion(view.searchPanel.chkMyPrices.isSelected(), user);
            view.selectProductPanel.actualizarPanelPrecios();
        } else if (e.getSource() == view.createPricePanel.btnEliminarPrecio) {
            boolean eliminado = PreciosService.eliminarPrecio(precioSeleccionado);
            if (eliminado) {
                this.buscarYActualizarPanelPrecios();
            }
            view.createPricePanel.cerrar();
        }
        profilePanelEvents(e);

    }

    /**
     * @author Andres Este metodo pone como observer al controlador en los
     * distintos objetos de las vistas.
     */
    private void listenObjects() {
        this.view.loginPanel.loginButton.addActionListener(this);
        this.view.loginPanel.signInButton.addActionListener(this);

        this.view.userSignInPanel.cboUserType.addActionListener(this);
        this.view.userSignInPanel.registerButton.addActionListener(this);
        this.view.userSignInPanel.cancelButton.addActionListener(this);

        this.view.userLoggedPanel.btnProfile.addActionListener(this);
        this.view.userLoggedPanel.btnLogout.addActionListener(this);

        this.view.offererLoggedPanel.btnProfile.addActionListener(this);
        this.view.offererLoggedPanel.btnLogout.addActionListener(this);
        this.view.offererLoggedPanel.btnpreciosyprod.addActionListener(this);

        this.view.selectProductPanel.btnAddProduct.addActionListener(this);

        this.view.searchPanel.btnSearch.addActionListener(this);
        this.view.searchPanel.chkMyPrices.addActionListener(this);
        this.view.searchPanel.precio_only_radioButton.addActionListener(this);
        this.view.searchPanel.precioDistanciaRadioButton.addActionListener(this);
        this.view.searchPanel.distanciaPrecioRadioButton.addActionListener(this);

        //Panel Perfil de usuarios
        this.view.profilePanel.btnDeleteAccount.addActionListener(this);
        this.view.profilePanel.btnUpdateProfile.addActionListener(this);

        this.view.selectProductPanel.priceTable.addMouseListener(this);
        //this.view.createPricePanel.btnModificarPrecio.addActionListener(this);
        this.view.createProductPanel.btnCreateProduct.addActionListener(this);
        this.view.selectProductPanel.btnAddProduct.addActionListener(this);
        this.view.selectProductPanel.btnAddPrice.addActionListener(this);
    }

    private void actualizarPanelPrecios() {
        if (productos == null) {
            return;
        }
        int criterio = view.searchPanel.getCriterioOrdenacion();
        //DEFAULT
        Comparator<PrecioDto> comparador = new ComparatorPorPrecio();
        if (criterio == SearchPanel.PRECIO_ONLY) {
            comparador = new ComparatorPorPrecio();
        } else if (criterio == SearchPanel.PRECIO_DISTANCIA) {
            if (distanciasCalculadas == false) {
                this.actualizarDistancias();
            }
            comparador = new ComparatorConDesempate(new ComparatorPorPrecio(), new ComparatorPorDistancia());
        } else if (criterio == SearchPanel.DISTANCIA_PRECIO) {
            if (distanciasCalculadas == false) {
                this.actualizarDistancias();
            }
            comparador = new ComparatorConDesempate(new ComparatorPorDistancia(), new ComparatorPorPrecio());
        }
        this.view.selectProductPanel.reordenar(comparador);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            if (user.getUserType() == 3) {
                productoSeleccionado = view.selectProductPanel.getProductoSeleccionado();
                precioSeleccionado = view.selectProductPanel.precioSeleccionado();
                if (precioSeleccionado != null && precioSeleccionado.getOferente().getId() == user.getId()) {
                    creandoPrecio = false;
                    this.view.showCreatePricePanel(precioSeleccionado, this, creandoPrecio);
                }
            } else {
                System.out.println("doble click");
                if (e.getSource() == this.view.selectProductPanel.priceTable) {
                    //userLocation= view.searchPanel.getLocationTextField();
                    precioSeleccionado = view.selectProductPanel.precioSeleccionado();
                    String direccionOferente = precioSeleccionado.getOferente().getDireccion();
                    if (!distanciasCalculadas) {
                        precioSeleccionado.setGmap(gmaps.mapsData(userLocation, direccionOferente));
                    }
                    GmapsDto gmap = precioSeleccionado.getGmap();
                    gmap.setSimpleImage(gmaps.getImageLink(userLocation, direccionOferente));
                    this.view.showProductDetailDialog(precioSeleccionado);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private void actualizarDistancias() {
        if (productos == null) {
            return;
        }
        for (ProductDto producto : productos) {
            for (PrecioDto precio : producto.getPrecios()) {
                precio.setGmap(gmaps.mapsData(userLocation, precio.getOferente().getDireccion()));
            }
        }
        distanciasCalculadas = true;
    }

    public ArbolCategoriesDto getArbol() {
        if (arbolCategorias == null) {
            arbolCategorias = CategoriesService.getArbol();
            if (arbolCategorias == null) {
                //JOptionPane.showMessageDialog(null, "Se generaran las categorias para empezar a cargar la aplicacion");
                //InitializationServices.cargarCategorias();
                //arbolCategorias = CategoriesService.getArbol();
            }
        }
        return arbolCategorias;
    }

    //individualizo por paneles para la mejora de lectura del codigo
    private void profilePanelEvents(ActionEvent e) {
        if (e.getSource() == this.view.profilePanel.btnDeleteAccount) {
            System.out.println("delete account");
            System.out.println(user.toString());
            int confirm = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea borrar su cuenta?", "Borrar Cuenta", JOptionPane.YES_NO_OPTION);
            if (confirm == 0) {
                boolean success = userServices.delete(user);
                if (success) {

                    JOptionPane.showMessageDialog(null, "Su cuenta ha sido borrada!" + getSeparator() + "Será recordado como un héroe!", "Borrar Cuenta", JOptionPane.OK_OPTION);
                }
                this.user = UsersService.logOut(this.user);
                this.view.logout();
            } else {
                System.out.println("Ufff estuvo cerca!");
            }

        } else if (e.getSource() == view.profilePanel.btnUpdateProfile) {
            System.out.println("update profile");

            String password = String.valueOf(this.view.profilePanel.txtPassword.getPassword());
            String repassword = String.valueOf(this.view.profilePanel.txtRePassword.getPassword());

            if (password.equals(repassword)) {
                // actualizar los datos del usuario
                if (!password.isEmpty()) {
                    user.setPassword(password);
                }
                user.setName(this.view.profilePanel.txtName.getText());
                user.setDireccion(this.view.profilePanel.txtAddress.getText());
                user.setCuit(this.view.profilePanel.txtCUIT.getText());
                user.setBusinessName(this.view.profilePanel.txtBusinessName.getText());

                boolean success = userServices.update(user);
                if (success) {

                    JOptionPane.showMessageDialog(null, "Los datos de su cuenta" + getSeparator() + "han sido actualizados", "Actualizacion Cuenta", JOptionPane.OK_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "Ha ocurido un error" + getSeparator() + "al actualizar sus datos", "Actualizacion Cuenta", JOptionPane.OK_OPTION);
                }

            }

        }
    }

    private String getSeparator() {
        return System.getProperty("line.separator");
    }

    private void buscarYActualizarPanelPrecios() {
        if (this.view.searchPanel.txtSearch.getText().isEmpty()) {
            return;
        }
        SearchDto search = view.searchPanel.getCriteriosBusqueda();
        userLocation = search.getUserLocation();

        productos = SearchService.buscar(search);
        this.view.showSelectProductPanel(productos);
    }
}
