package MOD05;


//Documentação classe Calculadora:


public class Calculadora {
    /*
    * Realiza a soma entre dois inteiros
    * @param a o primeiro inteiro a ser somado
    * @param b o segundo inteiro a ser somado
    * @return o resultado
    * */
    public static int sum(int a, int b){
        return a + b;
    }



    /* Realiza a subtração entre dois inteiros
    * @param a o primeiro inteiro a ser subtraído
    * @param b o segundo inteiro a ser subtraído
    * @return o resultado
    * */
    public static int sub(int a, int b){
        return a - b;
    }



    /* Realiza a multiplicação entre dois inteiros
    * @param a o primeiro inteiro a ser multiplicado
    * @param b o segundo inteiro a ser multiplicado
    * @return o resultado
    * */
    public static int mul(int a, int b){
        return a * b;
    }


    /* Realiza a divisão entre dois inteiros
    * @param a o primeiro inteiro a ser dividido
    * @param b o segundo inteiro a ser dividido
    * caso o segundo inteiro seja igual a 0
    * a divisão não é possível, retorna 0
    * @return o resultado
    * */
    public static int div(int a, int b){
        if (b == 0){
            return 0;
        } else {
            return a / b;

        }

    }
}
