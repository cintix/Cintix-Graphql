/*
 */
package cintix.graphql.schema;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author migo
 */
public class SchemaGenerator {

    public static String entity(Class<?> obj) {
        String schema = "";

        if (obj.isInterface()) {
            schema += "interface " + obj.getSimpleName() + " {\n";
            for (Method method : obj.getDeclaredMethods()) {
                String name = method.getName();

                if (name.startsWith("set")) {
                    continue;
                }
                if (name.startsWith("get") && name.length() > 3) {
                    name = name.substring(3, 4).toLowerCase() + name.substring(4);
                }

                boolean isListOrArray = method.getReturnType().isArray() || method.getReturnType().isAssignableFrom(List.class);            
                String returnType = method.getReturnType().getSimpleName();
                schema += "\t" + name + ": " + ((isListOrArray) ? "[" + returnType + "]" : returnType) + "\n";

            }
            schema += "}\n";
            return schema;
        }

        if (obj.isEnum()) {
            schema += "enum " + obj.getSimpleName() + " {\n";
            for (Field field : obj.getDeclaredFields()) {
                String name = field.getName();
                if (name.equals("$VALUES")) {
                    continue;
                }
                schema += "\t" + name + "\n";

            }
            schema += "}\n";
            return schema;
        }

        String interfaces = "";
        if (obj.getGenericInterfaces() != null) {
            for (Type type : obj.getGenericInterfaces()) {
                interfaces += "," + type.getTypeName().substring(type.getTypeName().lastIndexOf(".") + 1);
            }
            if (!interfaces.isEmpty()) {
                interfaces = interfaces.substring(1);
            }
        }
        schema += "type " + obj.getSimpleName() + ((!interfaces.isEmpty()) ? " implements " + interfaces : "") + " {\n";
        HashSet<String> fieldOrMethods = new HashSet<>();
        for (Method method : obj.getDeclaredMethods()) {
            String name = method.getName();

            if (name.startsWith("set")) {
                continue;
            }
            if (name.startsWith("get") && name.length() > 3) {
                name = name.substring(3, 4).toLowerCase() + name.substring(4);
            }

            boolean isListOrArray = method.getReturnType().isArray() || method.getReturnType().isAssignableFrom(List.class);            
            String returnType = method.getReturnType().getSimpleName();
            
            if (method.getReturnType().isAssignableFrom(List.class)) {
                System.out.println("Collection ? ? " + method.getReturnType());
            }
            
            fieldOrMethods.add(name + ":" + returnType);
            schema += "\t" + name + ": " + ((isListOrArray) ? "[" + returnType + "]" : returnType) + "\n";
        }

        for (Field field : obj.getDeclaredFields()) {
            String name = field.getName();
            String returnType = field.getType().getSimpleName();

            boolean isListOrArray = field.getType().isArray() || field.getType().isAssignableFrom(List.class);
                if (field.getType().isAssignableFrom(List.class)) {
                System.out.println("Collection ? ? " + field.getType().toGenericString());
            }

            if (!fieldOrMethods.contains(name + ":" + returnType)) {
                fieldOrMethods.add(name + ":" + returnType);
                schema += "\t" + name + ": " + ((isListOrArray) ? "[" + returnType + "]" : returnType) + "\n";

            }
        }

        schema += "}\n";
        return schema;
    }

}
