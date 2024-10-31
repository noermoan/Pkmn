package ru.mirea.pkmn.zininavo;

import ru.mirea.pkmn.Card;

import java.io.*;

public class CardExport {
    public static void Export (Card ecard) {
        if (ecard == null) {
            System.err.println("Ошибка: объект Card не должен быть null.");
            return;
        }
        String fileNm = "src/main/resources/" + ecard.getName() + ".crd";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileNm))) {
            oos.writeObject(ecard);
            System.out.println("Карточка успешно сериализована в " + fileNm);
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: файл не найден - " + fileNm);
        } catch (IOException e) {
            System.err.println("Ошибка при сериализации карточки: " + e.getMessage());
        }
    }
}
