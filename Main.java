import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        //infos do usuário
        double saldo = 1000;
        double saldoTemp;
        boolean run = true;
        String cpf = "123.456.789-00";
        String CPFscan;
        String senha = "01020304";
        String senhaScan;

        
        Scanner scan = new Scanner(System.in);   
        int tentativas = 0;
        boolean subLoop;
        while (run == true){
            subLoop = true;
            System.out.println("###############################################");
            System.out.println("Seja bem vindo ao sistema Caixa Eletrônico 0.01");
            System.out.println("###############################################");

            System.out.println("Digite o seu CPF");                
            CPFscan = scan.next();

            if (CPFscan.equals(cpf) && !cpf.equals("bloqueado")){
                do{
                System.out.println("Digite a sua senha: ");
                senhaScan = scan.next();
                    if (senhaScan.equals(senha)){
                        int input;
                        boolean exitBool = false;
                        while (exitBool == false){
                            System.out.println("Menu" + "\n" + "1 - Saldo" + "\n" + "2 - Depósito"
                            + "\n" + "3- Saque" + "\n" + "0 - Sair"
                            );
                            input = scan.nextInt();
                            switch (input){
                                case 0: 
                                    exitBool = true;
                                    System.out.println("Realizando o logout.");
                                    break;
                                case 1:
                                    System.out.println("Saldo disponível: ");
                                    System.out.println("R$"+saldo);
                                    break;

                                case 2:
                                    System.out.println("Digite o valor do depósito: ");
                                    saldoTemp = scan.nextInt();
                                    saldo = saldo + saldoTemp;
                                    break;

                                case 3:
                                    System.out.println("Digite o valor do saque: ");
                                    saldoTemp = scan.nextInt();
                                    if (saldoTemp > saldo){
                                      System.out.println("Saldo insuficiente para saque de valor digitado.");
                                    }
                                    else{
                                      saldo = saldo - saldoTemp;
                                    }
                                    break;

                                default: System.out.println("Opção inválida, tente novamente.");
                            }

                        }

                        subLoop = false;
                    }
                    else{
                    tentativas = tentativas + 1;
                    System.out.println("Digite novamente a sua senha: ");
                    }
                } while (tentativas < 2 && subLoop == true);
            }
            else {
                System.out.println("CPF inválido, acesso não permitido");
                run = false;
            }
            if (tentativas == 2){
                System.out.println("Excesso de tentativas! Conta bloqueada.");
                cpf = "bloqueado";
                tentativas = 0;
            }
            System.out.println("Fim.");
        }

    }
    
}
