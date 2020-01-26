package ru.malychev.jstasks.reflection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.util.Arrays;

public class Reflect {
//===========================================
    public static final String HELLO = "Hello";
//===========================================
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Разбор полей строковой константы: \"Hello\".");
        Class<?> sameClass = HELLO.getClass();
        Class<?> superClassString = sameClass.getSuperclass();
        String modifiersClassString = Modifier.toString(sameClass.getModifiers());
        System.out.println("==============================================================");
        if (!modifiersClassString.isEmpty()) System.out.print(modifiersClassString + " ");
        System.out.print("class " + sameClass.getName());
        if (superClassString != null)
            System.out.print(" extends " + superClassString.getName());
        System.out.println(" {");
        try {
            Field[] fields = sameClass.getDeclaredFields();
            System.out.println("\nПоля класса:");
            for (Field field : fields) System.out.println("Имя поля: " + field.getName());

            Field field = sameClass.getDeclaredField("value");
            field.setAccessible(true);
            System.out.print("  ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (!modifiers.isEmpty()) System.out.print(modifiers + " ");
            Object fieldValue = field.get(HELLO);
            System.out.print("value = ");
            System.out.println(Arrays.toString((char[]) fieldValue));
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        System.out.println("}");

        while (true) {
            System.out.print("Введите полное имя класса,\n" +
                    "включая наименование его пакета или \"exit\" для выхода: ");
            try {
                String className = reader.readLine();
                if (className.equals("exit") || className.equals("учше")) return;
                Class<?> classID = Class.forName(className);

                do {
                    Class<?> superClassID = classID.getSuperclass();
                    String modifiersClass = Modifier.toString(classID.getModifiers());
                    System.out.println();
                    if (!modifiersClass.isEmpty()) System.out.print(modifiersClass + " ");
                    System.out.print("class " + classID.getName() + " ");
                    if (superClassID != null)
                        System.out.print("extends " + superClassID.getName() + " ");
                    printConstructors(classID);
                    printMethods(classID);
                    printFields(classID);
                    System.out.println("}\n");
                    classID = superClassID;
                } while (classID != null && classID != Object.class);
            } catch (IOException | ClassNotFoundException e) {
                   e.printStackTrace();
            }
        }

    }

    public static void printConstructors(Class<?> classID) {
        Constructor<?>[] constructors = classID.getDeclaredConstructors();
        if (constructors.length == 0) return;

        System.out.println("{\nКонструкторы класса:");
        for (Constructor<?> construct : constructors) {
            String name = construct.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(construct.getModifiers());
            if (!modifiers.isEmpty()) System.out.print(modifiers + " ");
            System.out.print(name + "(");
            Class<?>[] paramTypes = construct.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class<?> classID){
        Method[] methods = classID.getDeclaredMethods();
        if (methods.length == 0) return;

        System.out.println("\nМетоды класса:");
        for (Method method : methods) {
            Class<?> returnType = method.getReturnType();
            String nameMethod = method.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(method.getModifiers());
            if (!modifiers.isEmpty()) System.out.print(modifiers + " ");
            System.out.print(returnType.getName() + " " + nameMethod + "(");
            Class<?>[] paramTypes = method.getParameterTypes();
            for (int i =0; i < paramTypes.length; i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class<?> classID) {
        Field[] fields = classID.getDeclaredFields();
        if (fields.length == 0) return;

        System.out.println("\nПоля класса:");
        for (Field field : fields) {
            Class<?> typeField = field.getType();
            String nameField = field.getName();
            System.out.print("  ");
            String modifiers = Modifier.toString(field.getModifiers());
            if (!modifiers.isEmpty()) System.out.print(modifiers + " ");
            System.out.println(typeField.getName() + " " + nameField + ";");
        }
    }
}
