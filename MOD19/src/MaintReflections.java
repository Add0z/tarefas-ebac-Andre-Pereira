import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MaintReflections {
    public static void main(String[] args) {
     Task printer = new Task();
//        System.out.println(printer.getClass());
//        System.out.println(printer.getClass().getSimpleName());
//        System.out.println(printer.getClass().getAnnotation(FirstAnnoT.class));
//        System.out.println(printer.getClass().getCanonicalName());
//        System.out.println(printer.getClass().getDeclaredAnnotation(FirstAnnoT.class));
//----------------------------------------------------------------------------------------//

    Class printer2 = Produto.class;
    System.out.println(printer2);

        try {
            Constructor cons = printer2.getConstructor();
            Produto prod1 = (Produto) cons.newInstance();
            System.out.println(cons);
            System.out.println(prod1);

            Field[] fields = prod1.getClass().getDeclaredFields();
            for (Field field: fields){
                Class<?> type = field.getType();
                String nome = field.getName();
                System.out.println(type);
                System.out.println(nome);
            }

            Method[] method = prod1.getClass().getDeclaredMethods();
            for (Method m: method){
                Class<?> type = m.getReturnType();
                String nome = m.getName();
                System.out.println(type);
                System.out.println(nome);

                System.out.println("Exec methods");
                if (m.getName().startsWith("get")){

                    System.out.println(m.invoke(prod1));
                } else {
                    for (Class Classestypes : m.getParameterTypes()){

                        if (Classestypes.equals(String.class)){
                            System.out.println(m.invoke(prod1, "Andre"));
                        } else if (Classestypes.equals(Long.class)) {
                            System.out.println(m.invoke(prod1, 19l));
                        } else {
                            System.out.println(m.invoke(prod1, 2d));
                        }
                    }


                }



            }

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }


    }
}