package bootcamp.poo;

public class Carro {
    private boolean ligado = false;
    private int marcha = 0; 
    private int velocidade = 0; 

    // -- MÉTODOS DE AÇÃO
    public void ligarCarro() {
        if(ligado == false) {
            ligado = true;
            System.out.println("O carro foi ligado.");
        } else {
            System.out.println("O carro já está ligado.");
        }
    }

    public void desligarCarro() {
        if(ligado == true) {
            ligado = false;
            System.out.println("O carro foi desligado.");
        } else {
            System.out.println("O carro já está desligado.");
        }
    }

    public void freiar() {
        if(this.velocidade > 0) {
            this.velocidade--;
            // System.out.printf("A velocidade atual é de %dKm/h\n", this.velocidade);
        } else {
            System.out.println("Não é possível desacelerar, pois a velocidade é menor que 0Km/h");
        }
    }

    public void acelerar() {
        if(this.velocidade <= 120) {
            this.velocidade++;
            // System.out.printf("A velocidade atual é de %dKm/h\n", this.velocidade);
        } else {
            System.out.println("Não é possível acelerar, pois a velocidade é maior que 120Km/h");
        }
    // }

    // public void acelerar(int velocidade) {
    //     if(this.velocidade <= 120) {
    //         this.velocidade = velocidade;;
    //         // System.out.printf("A velocidade atual é de %dKm/h\n", this.velocidade);
    //     } else {
    //         System.out.println("Não é possível acelerar, pois a velocidade é maior que 120Km/h");
    //     }
    }

    public void mudarMarcha() {
        switch(this.marcha) {
            case 0 -> { 
                System.out.println("Ponto Morto.");
                this.marcha++;
            }
            case 1 -> { 
                System.out.println("1ª marcha.");
                this.marcha++;
            }
            case 2 -> { 
                System.out.println("2ª marcha.");
                this.marcha++;
            }
            case 3 -> { 
                System.out.println("3ª marcha.");
                this.marcha++;
            }
            case 4 -> { 
                System.out.println("4ª marcha.");
                this.marcha++;
            }
            case 5 -> { 
                System.out.println("5ª marcha.");
                this.marcha++;
            }
            case 6 -> { 
                System.out.println("6ª marcha.");
                this.marcha++;
            }
            default -> System.out.println("Marcha Inválida;");
        }
    }

    // -- MÉTODOS DEE DIREÇÃO 
    public void virarDireita() {
        if(this.velocidade >= 1 && this.velocidade <= 40) {
            System.out.println("O carro virou para direita");
        } else {
            System.out.println("Não é possível virar o carro por ele está com velocidade maior que 40Km/h ou ele está parado.");
        }
    }

    public void virarEsquerda() {
        if(this.velocidade >= 1 && this.velocidade <= 40) {
            System.out.println("O carro virou para esquerda.");
        } else {
            System.out.println("Não é possível virar o carro por ele está com velocidade maior que 40Km/h ou ele está parado.");
        }
    }

    // -- MÉTODOS DE CONSULTA 
    public boolean isLigado() {
        return this.ligado;
    }

    public void verStatusCompleto() {
        System.out.println("-- Status Completo ---");
        System.out.println("Ligado: " + (this.ligado ? "Sim": "Não"));
        System.out.println("Marcha: " + (this.marcha - 1));
        System.out.println("Velocidade: " + this.velocidade + " km/h");
        System.out.println("-----------------------");
    }
        
}
