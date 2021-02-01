package controller;

import logic.LogicaProducto;

public class CtrlProducto {

    LogicaProducto logProd = new LogicaProducto();
    public void getProductos(){
        logProd.getProductos();
    }

    public void getProductoDetalle(int iCod){
        logProd.getProductoDetalle(iCod);
    }
}
