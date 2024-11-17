import java.util.Scanner;

public class Calculo {


    public Double h;
    public Double[] vetorY;
    public Double[] transformarvetor(){
        Double[] vetor;
        int count = 0;

        System.out.println("Digite o 1° valor da funcao");
        Double primeiro = scanner().nextDouble();
        System.out.println("Digite o 2° valor da funcao");
        Double segundo = scanner().nextDouble();
        System.out.println("Digite o intervalo entre elas. (H da funcao)");
        h = scanner().nextDouble();

        Double n = calculaH(primeiro,segundo,h);

        Double aux = primeiro;

        while (aux < segundo){
            aux += h;
            count++;
        }

        vetor =new Double[count];

        vetor[0] = primeiro;
        for (int i =1; i < count; i++){

            vetor[i] = vetor[i-1]+ h;
        }
        return vetor;
    }


    public static Scanner scanner() {
        return new Scanner(System.in);
    }

    public Double calculaH(Double a, Double b, Double h){
        return (b-a)/h;
    }
    public double funcao(double x) {
        return (x * x) + (2 * x) + 4 ;
    }
    public Double[] calculaFuncao(Double[] vetorX) {
        Double[] vetorY = new Double[vetorX.length];

        for (int i = 0; i < vetorX.length; i++) {
            vetorY[i] = funcao(vetorX[i]);
        }

        return vetorY;
    }

    public void Trapezio(Double[] vetorX){
        Double retorno = 0.0;
        vetorY=    calculaFuncao(vetorX);
        retorno = vetorY[0]/2 + vetorY[vetorY.length - 1]/2;
        for (int i = 1; i < vetorY.length - 1;i++) {
            retorno += vetorY[i];
        }

        System.out.println(retorno * h);
    }
    public void Simpson1(Double[] vetorX){
        Double retorno = 0.0;
        vetorY=    calculaFuncao(vetorX);
        retorno = vetorY[0] + vetorY[vetorY.length - 1] + (vetorY[vetorY.length - 2] * 4);
        for (int i = 1; i < vetorY.length - 2; i++){
            if(i % 2 == 0){
                retorno += vetorY[i] * 4;
            }
            else
            {
                retorno += vetorY[i] * 2;
            }
        }
        System.out.println(retorno * h / 3);
    }

    public void Simpson2(Double[] vetorX){
        Double retorno = 0.0;
        vetorY=    calculaFuncao(vetorX);
        retorno = vetorY[0] + (vetorY[vetorY.length - 3] * 3) + (vetorY[vetorY.length - 2] * 3) + (vetorY[vetorY.length - 1]);
        for(int i = 1; i < vetorY.length - 3; i++){
            if ((i) % 3 == 0){
                retorno += vetorY[i] * 2;
            }else{
                retorno += vetorY[i] * 3;
            }
        }
        System.out.println(retorno * 3 * h / 8);
    }

}
