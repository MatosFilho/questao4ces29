package source;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VulnerableClass {
  private static String buffer;
  private static String texto;

  /*
  public static String pegaDoBuffer () {
  Scanner console = new Scanner (System.in);
  String buff = console.nextLine();
  console.close();
  return buff;
  }
 */

  public static void setTexto(String txt) {
    texto = txt;
  }

  public static void setBuffer(String op) {
    buffer = op;
  }
  
  /**
   * Classe vulnerável.
   * parametro da fiuncao @param fileName
   * tipo retorno String @return 
   */
  
  public static String vulnerableMethod(String fileName) {
    boolean loop = true;
    String msg = "";

    Pattern pattern = Pattern.compile("[^A-Za-z0-9._]");
    Matcher matcher = pattern.matcher(fileName);
    if (matcher.find()) {
      msg = "Nome de arquivo não atende aos padrões.";
      loop = false;
    }

    while (loop) {
      System.out.print("Digite a operacao desejada para realizar no arquivo"
          + " <R para ler um arquivo, "
          + "W para escrever em um arquivo, EXIT para sair>? ");

      //String opr= pegaDoBuffer ();
      String opr = buffer;

      if (opr.equals("R")) {
        try {
          String scurrentLine;
          BufferedReader br = new BufferedReader(new FileReader(fileName));
          while ((scurrentLine = br.readLine()) != null) {
            System.out.println(scurrentLine);
          }
          msg = "Arquivo impresso na tela com sucesso.";
          br.close();
          loop = false;
        } catch (IOException e) { 
          e.printStackTrace(); 
        } 
      } else if (opr.equals("W")) {
        try {
          BufferedWriter buffWrite = new BufferedWriter(new FileWriter(fileName));
          String linha = "";
          System.out.println("Escreva algo: ");
          linha = texto;
          buffWrite.append(linha + "\n");
          msg = "Escrita de arquivo realizada com sucesso.";
          buffWrite.close();
          loop = false;
        } catch (IOException e) { 
          e.printStackTrace(); 
        } 
      } else if (opr.equals("EXIT")) {
        System.out.println("Fim da manipulacao do arquivo.");
        msg = "Fim da manipulacao do arquivo.";
        loop = false;
      } else {
        System.out.println("Comando invalido. Tente novamente");
        msg = "Comando invalido. Tente novamente.";
        loop = false;
      }
    }
    return msg;
  }
}
