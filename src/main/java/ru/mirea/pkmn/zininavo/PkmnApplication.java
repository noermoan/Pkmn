package ru.mirea.pkmn.zininavo;

import ru.mirea.pkmn.Card;

public class PkmnApplication {

    public static void main(String[] args) {
        CardImport cardImport = new CardImport();
        Card myCard = cardImport.readFromFile("src/main/resources/my_card.txt");
        System.out.println(myCard.toString());
        CardExport cardExport = new CardExport();
        cardExport.Export(myCard);

        myCard = cardImport.Import("src/main/resources/Corvisquire.crd");
        System.out.println(myCard);
    }
}
