import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaBancaria {

    static Scanner s = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;

    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        int cont = 1;

        do{
            System.out.println("------------------------------------------------------");
            System.out.println("---------Bem vindos ao banco Tio patinhas-------------");
            System.out.println("------------------------------------------------------");
            System.out.println("------------------------------------------------------");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Depositar");
            System.out.println("3 - Sacar");
            System.out.println("4 - Trasnferir");
            System.out.println("5 - Listar");
            System.out.println("6 - Sair");

            System.out.println("Selecione uma operação que deseja realizar: ");
            cont = s.nextInt();;

            switch (cont) {
                case 1:
                    criarConta();
                    break;

                case 2:
                    depositar();
                    break;

                case 3:
                    sacar();
                    break;

                case 4:
                    transferir();
                    break;

                case 5:
                    listarContas();
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while(cont!= 6);
    }

    public static void criarConta() {

        System.out.println("\nNome: ");
        String nome = s.next();

        System.out.println("\nCPF: ");
        String cpf = s.next();

        System.out.println("Email: ");
        String email = s.next();

        Pessoa cliente = new Pessoa(nome, cpf, email);

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        System.out.println("Sua conta foi criada com sucesso!");
    }

    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta contaa : contasBancarias) {
                if(contaa.getNumeroConta() == numeroConta) {
                    conta = contaa;
                }
            }
        }
        return conta;
    }

    public static void depositar() {
        System.out.println("Número da conta: ");
        int numeroConta = s.nextInt();
        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja depositar? ");
            Double valorDeposito = s.nextDouble();

            conta.depositar(valorDeposito);
        }else {
            System.out.println(" Conta não encontrada");
        }
    }

    public static void sacar() {
        System.out.println("Número da conta: ");
        int numeroConta = s.nextInt();

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Qual valor deseja sacar? ");
            Double valorSaque = s.nextDouble();

            conta.sacar(valorSaque);
            System.out.println("Saque realizado com sucesso!");
        }else {
            System.out.println("Conta não encontrada");
        }
    }

    public static void transferir() {
        System.out.println("Número da conta que vai enviar a transferência: ");
        int numeroContaRemetente = s.nextInt();

        Conta contaRemetente = encontrarConta(numeroContaRemetente);

        if(contaRemetente != null) {
            System.out.println("Número da conta do destinatário: ");
            int numeroContaDestinatario = s.nextInt();

            Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

            if(contaDestinatario != null) {
                System.out.println("Valor da transferência: ");
                Double valor = s.nextDouble();

                contaRemetente.transferencia(contaDestinatario, valor);

            }else {
                System.out.println("A conta para depósito não foi encontrada");
            }

        }else {
            System.out.println(" Conta para transferência não encontrada");
        }
    }

    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for(Conta conta: contasBancarias) {
                System.out.println(conta);
            }
        }else {
            System.out.println("Não há contas cadastradas");
        }
    }
}
