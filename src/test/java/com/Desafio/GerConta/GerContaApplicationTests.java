package com.Desafio.GerConta;

import com.Desafio.GerConta.FactoryCalculo.RecebimentoAtraso;
import com.Desafio.GerConta.FactoryCalculo.RecebimentoFactory;
import com.Desafio.GerConta.model.ContasReceberModel;
import com.Desafio.GerConta.model.enums.RecebimentoAlugueis;
import com.Desafio.GerConta.model.enums.TipoRecebimento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class GerContaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testeCalculoFactoryRecebimentoAluguelAtrasado(){
		ContasReceberModel contasReceberModel= new ContasReceberModel( );
		contasReceberModel.setValorRecebido(new BigDecimal("100"));

		BigDecimal atraso = contasReceberModel.getValorRecebido().multiply(new BigDecimal("0.035"));
		BigDecimal atrasos1 =  contasReceberModel.getValorRecebido().add(atraso);
		Assertions.assertEquals(new BigDecimal("103.500"), atrasos1);
	}

	@Test
	void testeCalculoFactoryRecebimentoAluguelFactory(){
		//teste após classe construida
		ContasReceberModel contasReceberModel= new ContasReceberModel( );
		contasReceberModel.setValorRecebido(new BigDecimal("100"));

		RecebimentoAtraso recebimentoAtraso = new RecebimentoAtraso();
		BigDecimal atraso =  recebimentoAtraso.calcularRecebimento(contasReceberModel);

		Assertions.assertEquals(new BigDecimal("103.500"), atraso);
	}

}
