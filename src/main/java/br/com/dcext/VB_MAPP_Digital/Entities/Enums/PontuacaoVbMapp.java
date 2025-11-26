package br.com.dcext.VB_MAPP_Digital.Entities.Enums;

public enum PontuacaoVbMapp {
    NAO_CONCLUIDO(0.0),
    MEIO_CONCLUIDO(0.5),
    CONCLUIDO(1.0);
    private final double valor;

    PontuacaoVbMapp(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
