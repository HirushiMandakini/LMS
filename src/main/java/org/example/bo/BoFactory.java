package org.example.bo;

import org.example.bo.impl.*;
import org.example.bo.impl.AdminBoImpl;

public class BoFactory {
    public static  BoFactory boFactory;

    public BoFactory() {

    }

    public static BoFactory getBoFactory(){
        return (boFactory ==null) ? boFactory=new BoFactory() : boFactory;
    }
    public enum BOTypes{
        ADMIN,BOOK,BORROW,BRANCH,USER
    }

    public SuperBo getBo(BOTypes boTypes){
        switch (boTypes){
            case ADMIN:
                return new AdminBoImpl();
            case BOOK:
                return new BookBoImpl();
            case BORROW:
                return new BorrowBoImpl();
            case BRANCH:
                return new BranchBoImpl();
            case USER:
                return new UserBoImpl();
        }
        return null;
    }
}
