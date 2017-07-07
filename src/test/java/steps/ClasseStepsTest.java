package steps;

import static org.junit.Assert.assertEquals;

import cucumber.api.java.es.Dado;
import cucumber.api.java.it.Quando;
import cucumber.api.java.pt.Então;

import source.VulnerableClass;


public class ClasseStepsTest {
  
  VulnerableClass vc;
  String arquivo;
  String msg;
  
  @Dado("^um arquivo com nome invalido$")
public void um_arquivo_com_nome_invalido() {
    arquivo = "!nãoabrir!";
  }

  @Quando("^ocorre a tentativa de abrir o arquivo$")
public void ocorre_a_tentativa_de_abrir_o_arquivo() {
    msg = VulnerableClass.vulnerableMethod(arquivo);
  }

  @Então("^uma mensagem de erro e mostrada$")
public void uma_mensagem_de_erro_e_mostrada() {
    assertEquals("Nome de arquivo não atende aos padrões.", msg);
  }
  
  @Dado("^um arquivo com nome valido para leitura$")
public void um_arquivo_com_nome_valido_para_leitura() {
    arquivo = "arq.txt";
  }

  @Quando("^esse arquivo e aberto e definido para leitura$")
public void esse_arquivo_e_aberto_e_definido_para_leitura() {
    vc.setBuffer("R");
    msg = vc.vulnerableMethod(arquivo);
  }

  @Então("^resultado do arquivo e mostrado na tela$")
public void resultado_do_arquivo_e_mostrado_na_tela() {
    assertEquals("Arquivo impresso na tela com sucesso.", msg);
  }
  
  @Dado("^um arquivo com nome valido para ser escrito$")
public void um_arquivo_com_nome_valido_para_ser_escrito() {
    arquivo = "arq2.txt";
  }
  
  /**
   * .
   */
  @Quando("^esse arquivo e aberto e definido para escrita$")
public void esse_arquivo_e_aberto_e_definido_para_escrita() {
    vc.setBuffer("W");
    vc.setTexto("Escrita feita");
    msg = vc.vulnerableMethod(arquivo);
  }

  @Então("^escrita e realizada e mostrada na tela$")
public void escrita_e_realizada_e_mostrada_na_tela() {
    assertEquals("Escrita de arquivo realizada com sucesso.", msg);
  }

  @Dado("^que o usuario abriu um arquivo$")
public void que_o_usuario_abriu_um_arquivo() {
    arquivo = "arq.txt";
  }

  @Quando("^ele nao quer mais o modificar$")
public void ele_nao_quer_mais_o_modificar() {
    vc.setBuffer("EXIT");
    msg = vc.vulnerableMethod(arquivo);
  }

  @Então("^ele decide sair$")
public void ele_decide_sair()  {
    assertEquals("Fim da manipulacao do arquivo.", msg);
  }
  
  @Dado("^que o usuario abriu corretamente um arquivo$")
public void que_o_usuario_abriu_corretamente_um_arquivo() {
    arquivo = "arq.txt";
  }

  @Quando("^ele escolhe um comando nao valido$")
public void ele_escolhe_um_comando_nao_valido() {
    vc.setBuffer("k");
    msg = vc.vulnerableMethod(arquivo);
  }

  @Então("^ele e avisado do ocorrido$")
public void ele_e_avisado_do_ocorrido() {
    assertEquals("Comando invalido. Tente novamente.", msg);
  }
 
}
