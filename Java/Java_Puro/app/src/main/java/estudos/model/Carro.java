package estudos.model;

public class Carro {
    private boolean ligado = false;
    private int marcha = 0; 
    private int velocidade = 0; 

    // Construtor garante o estado inicial correto.
    public Carro() {
        System.out.println("Carro criado. Estado inicial: Desligado, Ponto Morto, 0 km/h.");
    }

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
        if(this.marcha == 0 && velocidade == 0) {
            if(ligado == true) {
                ligado = false;
                System.out.println("O carro foi desligado.");
            } else {
                System.out.println("O carro já está desligado.");
            }
        } else {
            System.out.println("Só é possível desligar o carro se a marcha estiver em ponto morto (marcha 0) e sua velocidade em 0 km.w");
        }
    }

    public void frear() {
        //Para impedir que o carro freie desligado
        if(ligado == true) {
            if(this.velocidade > 0) {
                this.velocidade--;
            } else {
                System.out.println("Não é possível desacelerar, pois a velocidade é menor que 0Km/h.");
            }
        } else {
            System.out.println("Não é possível freiar com o carro desligado.");
        }
    }

    public void acelerar() {
        if (!this.ligado) {
            System.out.println("ERRO: Não é possível acelerar com o carro desligado.");
            return;
        }

        boolean podeAcelerar = false;
        switch(this.marcha) {
            case 0 -> System.out.println("ERRO: Não é possível acelerar em Ponto Morto.");
            case 1 -> { 
                if(this.velocidade < 20) podeAcelerar = true;
            }
            case 2 -> { 
                if(this.velocidade < 40) podeAcelerar = true;
            }
            case 3 -> { 
                if(this.velocidade < 60) podeAcelerar = true;
            }
            case 4 -> { 
                if(this.velocidade < 80) podeAcelerar = true;
            }
            case 5 -> { 
                if(this.velocidade < 100) podeAcelerar = true;
            }
            case 6 -> { 
                if(this.velocidade < 120) podeAcelerar = true;
            }
        }

        if(podeAcelerar) {
            this.velocidade++;
            System.out.println("Acelerando... Velocidade atual: " + this.velocidade + "Km/h");
        } else if(this.marcha > 0) {
            System.out.println("Velocidade máxima para a " + this.marcha + "ª marcha atingida. Troque de marcha para acelerar mais.");
        }
    }

    public void aumentarMarcha() {
        if(!this.ligado) {
            System.out.println("ERRO: Não é possível trocar de marcha com o carro desligado.");
            return;
        }

        if(this.marcha < 6) {
            this.marcha++;
            System.out.println("Marcha aumentada para: " + (this.marcha == 0 ? "Ponto Morto": this.marcha + "ª"));
        } else {
            System.out.println("O carro já está na marcha máxima (6ª).");
        }
    }

    public void reduzirMarcha() {
        if(!this.ligado) {
            System.out.println("ERRO: Não é possível trocar de marcha com o carro desligado.");
            return;
        }

        if(this.marcha > 0) {
            this.marcha--;
            System.out.println("Marcha reduzida para: " + (this.marcha == 0 ? "Ponto Morto": this.marcha + "ª"));
        } else {
            System.out.println("O carro já está em Ponto Morto.");
        }
    }

    // -- MÉTODOS DEE DIREÇÃO 
    public void virarDireita() {
        virar("direita");
    }

    public void virarEsquerda() {
        virar("direita");
    }

    private void virar(String direcao) {
        if(!this.ligado) {
            System.out.println("ERRO: Não é possível virar com o carro desligado.");
            return;
        } 

        if(this.velocidade >= 1 && this.velocidade <= 40) {
            System.out.println("O carro virou para a " + direcao + ".");
        } else {
            System.out.println("ERRO: Só é possível virar com velocidade entre 1 km/h e 40 km/h.");
        }
    }

    // -- MÉTODOS DE CONSULTA 
    public boolean isLigado() {
        return this.ligado;
    }

    public void verStatusCompleto() {
        System.out.println("-- Status Completo ---");
        System.out.println("Ligado: " + (this.ligado ? "Sim": "Não"));
        System.out.println("Marcha: " + (this.marcha));
        System.out.println("Velocidade: " + this.velocidade + " km/h");
        System.out.println("-----------------------");
    }
        
}
