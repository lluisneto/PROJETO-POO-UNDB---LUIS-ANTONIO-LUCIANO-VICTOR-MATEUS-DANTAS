package br.com.controleagil.model;

import br.com.controleagil.exception.RegraNegocioException;

import java.math.BigDecimal;

/*
 * Responsabilidade: o cliente das vendas SEM cadastro (quem compra no balcão e não quer se
 * identificar). Assim dá para anotar um pedido sem escolher um cliente específico.
 *
 * Conceitos de POO:
 *  - HERANÇA: "extends Cliente". É um cliente como os outros (o Pedido aceita sem mudar nada).
 *  - SOBRESCRITA e POLIMORFISMO: abrirContaFiado() e isIdentificado() se comportam diferente.
 *    Quem não se identifica não compra fiado, porque não teria de quem cobrar (RC19).
 */
public class ClienteSemIdentificacao extends Cliente {

    /** Nome mostrado nas telas. */
    public static final String NOME = "Cliente sem identificação";

    public ClienteSemIdentificacao() {
        super(NOME, null, null);
    }

    /** RC19: sem identificação não existe conta fiado. */
    @Override
    public void abrirContaFiado(BigDecimal limite) {
        throw new RegraNegocioException("O cliente sem identificação não compra fiado. "
                + "Para vender fiado, cadastre o cliente na tela Clientes e abra a conta dele.");
    }

    /** Este é o único cliente que não é identificado. */
    @Override
    public boolean isIdentificado() {
        return false;
    }
}
