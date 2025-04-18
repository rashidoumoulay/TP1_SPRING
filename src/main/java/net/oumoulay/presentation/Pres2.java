package net.oumoulay.presentation;

import net.oumoulay.dao.IDao;
import net.oumoulay.metier.IMetier;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Scanner s = new Scanner(new File("config.txt"));
        String daoClassName = s.nextLine();
        Class cDao = Class.forName(daoClassName);
        IDao dao = (IDao) cDao.newInstance();
        System.out.println(dao.getData());

        String metierClassName = s.nextLine();
        Class cMetier = Class.forName(metierClassName);
        IMetier metier = (IMetier) cMetier.getConstructor(IDao.class).newInstance(dao);
        System.out.println("res = "+metier.calcul());
    }
}
