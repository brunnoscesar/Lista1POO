package br.inatel.cdg.algebra.scene;

public class Reta {

    Ponto ponto1 = new Ponto();
    Ponto ponto2 = new Ponto();

    double coeficienteAngular(Ponto ponto1, Ponto ponto2){

        double m = (ponto2.y - ponto1.y) / (ponto2.x - ponto1.x);
        return m;
    }

    double coeficienteLinear (Ponto ponto1, Ponto ponto2){

        double ca = coeficienteAngular(ponto1, ponto2);

        double b = ponto1.y - (ca * ponto1.x);

        return b;
    }
}
