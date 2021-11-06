package co.usa.auditoriog35.auditoriog35.Repository;

import co.usa.auditoriog35.auditoriog35.Model.Cliente;

public class ContadorClientes {
    private Long total;
    private Cliente client;
    public ContadorClientes(Long total, Cliente client) {
        this.total = total;
        this.client = client;
    }
    public Long getTotal() {
        return total;
    }
    public void setTotal(Long total) {
        this.total = total;
    }
    public Cliente getClient() {
        return client;
    }
    public void setClient(Cliente client) {
        this.client = client;
    }

    



}
