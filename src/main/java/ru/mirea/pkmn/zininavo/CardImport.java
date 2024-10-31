package ru.mirea.pkmn.zininavo;

import ru.mirea.pkmn.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CardImport {
    private Card card;

    public static void main(String[] args) {
        /*String filePath = "src/main/resources/my_card.txt";
        CardImport cardImport = new CardImport();
        Card card = cardImport.readFromFile(filePath);
        System.out.println(card);*/
    }
    public Card readFromFile(String filePath) {
        Card card = new Card();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            //stage
            String line = bufferedReader.readLine();
            card.setPokemonStage(PokemonStage.valueOf(line)); //br 1
            //name
            line = bufferedReader.readLine();
            card.setName(line); //2
            //hp
            line = bufferedReader.readLine();
            card.setHp(Integer.parseInt(line/*bufferedReader.readLine()*/));//3
            //pokemontype
            line = bufferedReader.readLine();
            card.setPokemonType(EnergyType.valueOf(line/*bufferedReader.readLine()*/));//4
            //evolves
            line = bufferedReader.readLine();
            if (line != "-") { //5
                CardImport newCardImport = new CardImport();
                Card newCard = new Card();
                card.setEvolvesFrom(newCard);
            } else {
                card.setEvolvesFrom((null));
            }
            //skills
            line = bufferedReader.readLine();
            String[] skills = line.split(", ");
            List<AttackSkill> skills1 = new ArrayList<>(); // Изменено на список

            for (String i : skills) {
                String[] ptat = i.split("/");
                //System.out.println(ptat[0] + ptat[1] + ptat[2]);
                if (ptat.length >= 3) {
                    try {
                        AttackSkill at = new AttackSkill(ptat[1], ptat[0], Integer.parseInt(ptat[2]));
                        skills1.add(at);
                    } catch (NumberFormatException e) {
                        System.err.println("Ошибка преобразования числа: " + ptat[2]);
                    }
                } else {
                    System.err.println("Недостаточно данных для навыка: " + i);
                }
            }
            //System.out.println(skills1);
            card.setSkills(skills1);
            //weakness
            line = bufferedReader.readLine();
            card.setWeaknessType(EnergyType.valueOf(line));//7
            //resisnance
            line = bufferedReader.readLine();
            if (Objects.equals(line, "null")) {
                card.setResistanceType(null);//8
            } else {
                card.setResistanceType(EnergyType.valueOf(line));
            }
            //retreatcost
            line = bufferedReader.readLine();
            card.setRetreatCost(line);//9
            //set
            line = bufferedReader.readLine();
            card.setGameSet(line);//10
            line = bufferedReader.readLine();
            if (line.length() != 1) {
                card.setRegulationMark('-');
            } else {
                card.setRegulationMark(line.charAt(0));
            }
            //owner
            line = bufferedReader.readLine();
            String[] ownPt = line.split("/");
            Student student = new Student();
            student.setFirstName(ownPt[1]);
            student.setSurName(ownPt[0]);
            student.setFamilyName(ownPt[2]);
            student.setGroup(ownPt[3]);
            card.setPokemonOwner(student);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String serilPath = "src/main/resources/" + card.getName() + ".crd";
        //serializeCard(card, serilPath);
        return card;
    }

    public Card Import (String fileNm) {

        try {
            FileInputStream fileInputStream;
            fileInputStream = new FileInputStream(fileNm);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            card = (Card) objectInputStream.readObject();
            System.out.println("Файл десериализован");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return card;
    }
}