// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Calculo programa = new Calculo();


        Double vetor[] = programa.transformarvetor();

        if ((vetor.length - 1) % 2 == 0) {
            programa.Simpson1(vetor);
        }
        else if ((vetor.length - 1) % 3 == 0) {
            programa.Simpson2(vetor);
        } else
            programa.Trapezio(vetor);
    }

}