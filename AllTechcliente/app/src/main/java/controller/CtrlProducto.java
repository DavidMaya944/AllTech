package controller;

import logic.LogicaProducto;

public class CtrlProducto {

    LogicaProducto logProd = new LogicaProducto();

    public void getProductoDetalle(int iCod){
        logProd.getProductoDetalle(iCod);
    }

    public void insert_compra(){
        logProd.insertCompra();
    }
}
