import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;



public class App {
       
        public static void main(String[] args) throws InterruptedException, IOException, ParseException{
            int opcao, qtdDigitada = 0;
            ArrayList <Produto> produtos = new ArrayList <> ();
            Scanner in = new Scanner(System.in);
            LocalDate dateI;
            LocalDate dateF;

            do {
                System.out.println("\n****\nMENU\n****\n");
                System.out.println("1 - Cadastro de produtos");
                System.out.println("2 - Relatórios");
                System.out.println("3 - Registrar venda");
                System.out.println("0 - Sair");
                System.out.println("             ");
                System.out.print("Opção: ");
    
                opcao = in.nextInt();
                in.nextLine();

        if (opcao == 1 ){
                System.out.println("\n*******************\nCadastro de produtos\n*******************\n");
                System.out.println("1 - Consultar");
                System.out.println("2 - Incluir");
                System.out.println("             ");
                System.out.print("Opção: ");

                opcao = in.nextInt();
                in.nextLine();

                if (opcao == 2){

                    System.out.println("\n*********************\nPRODUTOS - INCLUSÃO\n**********************\n");
    
                 System.out.print("Código: "); 
                 int codigo = (in.nextInt());

                 System.out.print("Nome: ");
                 String nome = (in.next());

                 System.out.print("Valor: ");
                 Double valor = (in.nextDouble());

                 System.out.print("Quantidade em estoque: ");
                 int qtdEstoque = (in.nextInt());


                 produtos.add(new Produto (nome,codigo,valor,qtdEstoque));
                 System.out.println("Operação realizada com sucesso !");
                 voltarMenu(in); 
                   
                  }else if (opcao == 1){
                  
                    System.out.println("\n*******************\nPRODUTOS - CONSULTA\n*********************\n");
                    System.out.println("1 - Consultar pelo nome do produto ");
                    System.out.println("2 - Para ver todos");
                    System.out.println("             ");
                    System.out.print("Opção: ");
         
                    opcao = in.nextInt();
                     in.nextLine();

                     if(opcao == 1){
                        System.out.println("Nome do produto a buscar: ");
                        String nomeDigitado = ( in.nextLine());
      
                           for (Produto produto : produtos) {

                           if( nomeDigitado.equals(produto.getNome()))
                          System.out.printf("Código: %d\nNome: %s\nValor: R$ %.2f\nQuantidade no estoque: %d\n", produto.getCodigo(), produto.getNome() ,produto.getValor(), produto.getQtdEstoque());
                           else 
                            continue;}
                           voltarMenu(in); 
                       
                       
                    }else if (opcao == 2){
                          
                            if (produtos.size() == 0) {
                                System.out.println("\nNão há produtos cadastrados para exibir." );
                                voltarMenu(in);
                                continue;
                            }
                            System.out.println("===================");
                            System.out.println("PRODUTOS ENCONTRADOS");
                            System.out.println("===================");
            
                            for (Produto produto : produtos) {
            
                            System.out.printf("\nCódigo: %d\nNome: %s \nValor: R$ \nQuantidade no estoque: %d\n", produto.getCodigo(), produto.getNome(), produto.getValor(), produto.getQtdEstoque());
                             }}}voltarMenu(in);
            
            
            
            
            
            
             
                }else if (opcao == 3){
                   if (produtos.size() == 0) {
                        System.out.println("\nNão há produtos cadastrados para venda." );
                        voltarMenu(in);
                        continue;}
                System.out.println("Código do produto: ");
                int codDigitado = (in.nextInt());
                // int qtdDigitada = 0;
                for (Produto produto : produtos) {
                    
        
                 if( codDigitado == (produto.getCodigo())){
                 System.out.println("\n*********************************************\n*************************REGISTRAR VENDA*************************\n*********************************************\n");
                 System.out.printf("Produto localizado: [%s].", produto.getNome());

                 System.out.print("\nData : ");
                 String dataDigitada = in.next(); 
                 produto.dAta = LocalDate.parse(dataDigitada, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                
                 System.out.print("Quantidade: ");
                 qtdDigitada = (in.nextInt());

                 produto.qTdEstoque = produto.getQtdEstoque() - qtdDigitada;
                 
                 
                 }
                 System.out.println("Operação realizada com sucesso !!");
                voltarMenu(in);
                
                
                }
                
               
                
               
                
                
                
                
                
                
        
                           
                           

                            
                        
            }else if (opcao == 2){
                System.out.println("\n****************\nRelatórios\n******************\n");
                System.out.println("1 - Produtos");
                System.out.println("2 - Venda por período - detalhado");
                System.out.println("0 - voltar");
                System.out.println("             ");
                System.out.print("Opção: ");
        
                 opcao = in.nextInt();
                 in.nextLine(); 
                   

                    if(opcao == 1){
                        if (produtos.size() == 0) {
                            System.out.println("\nNão há produtos cadastrados para exibir." );
                            voltarMenu(in);
                            continue;}
                            System.out.println("\n*******************\n**************LISTAGEM DE PRODUTOS**************\n*********************\n");
                        Double valorMaior = 0.0;
                       for (Produto produto : produtos) {
 
                          if(valorMaior < produto.getValor() )
                          valorMaior = produto.getValor();
                            
                             System.out.printf("Código: %d\nNome: %s \nValor: R$ %.2f\nQuantidade no estoque: %d\n************************\n", produto.getCodigo(), produto.getNome(), produto.getValor(), produto.getQtdEstoque());}
                              System.out.printf("Maior valor: R$%.2f      ", valorMaior);
                        
                  
                           Double valorMenor = valorMaior;
                        for (Produto produto : produtos) {
                            if(produto.getValor() < valorMenor)
                                valorMenor = produto.getValor();
                    }System.out.printf("Menor valor: R$%.2f      ", valorMenor);
                            
                          
                           Double media = 0.0;
                           for (Produto produto : produtos) {
                               media += produto.getValor();
                                
                    } media = media/produtos.size();
                    
                    System.out.printf("Média valor: R$%.2f      ",  media);


                     }else if (opcao == 2){
                        if (produtos.size() == 0) {
                            System.out.println("\nNão há produtos cadastrados para exibir." );
                            voltarMenu(in);
                            continue;}
                         

                        System.out.println("\n*******************\n**************RELATÓRIO DE VENDAS - DETALHADO**************\n*********************\n");
                        System.out.println("Informe o período de emissão.\n-----------------------------");
                         Double total = 0.0;   
                         Double media = 0.0;
                        for (Produto produto : produtos){
                           
                              
                        System.out.print("\nData inicial : ");
                        String dataInicial = in.next(); 
                        dateI = LocalDate.parse(dataInicial, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                        System.out.print("\nData final : ");
                        String dataFinal = in.next(); 
                        dateF = LocalDate.parse(dataFinal, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                      
                           if (produto.getData().isAfter(dateI) && produto.getData().isBefore(dateF)){
                               
                            System.out.printf("\nNome: %s \nValor: R$ %.2f\nQuantidade no estoque: %d \n************************\n", produto.getNome(), produto.getValor(), produto.getQtdEstoque());
                            System.out.printf("\nData: " + produto.getData());
                           
                           }  

                           total += produto.getValor();     
                        
                    } 
                      
                      total = total * qtdDigitada;
                      System.out.printf("\nValor total: R$ %.2f ",total);
                    
                    media = total/ produtos.size();
                      
                     System.out.printf("\nValor médio das vendas: R$ %.2f ", media);
                    }
                    }









 







 
              
             } while (opcao != 0);
    
            System.out.println("Fim do programa!");
    
            in.close();
        }
    
    
        private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
            System.out.println("\nPressione ENTER para voltar ao menu.");
            in.nextLine();
    
            // Limpa toda a tela, deixando novamente apenas o menu
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                System.out.print("\033[H\033[2J");
            
            System.out.flush();
        }
{
    }
}
