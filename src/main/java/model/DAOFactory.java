package main.java.model;

import main.java.model.propertiesFileSource.PropertiesFileDAOFactory;

/**
 * Created by PalibinFamily on 12.06.2018.
 * Данный класс содержит в себе информацию об источнике данных. в нашем случае по заданию источник - properties file.
 * Допустим, если бы нам нужно было добавить базу данных, то мы бы создали еще одну константу
 * public static final int FROM_DATA_BASE = 2;
 * Каждый новый источник данных добавляет одну константу, которая определяет режим получения данных нашим приложением.
 *
 * Абстрактный блок get методов (getResumeContent()) определяет какие обработчики (обработчики конкретно чего) должны
 * быть возвращены наследниками класса DAOFactory. К примеру, если бы мы имели еще один properties file с паспортными
 * данными, у нас появился бы новый метод getPassportData() с возвращаемой реализацией интерфейса PassportDataHandler,
 * который в свою очередь определяет нужный нам функционал в отношении наших данный (к примеру getSerialNumber). С
 * появлением нового абстрактного метода мы обязываем всех наследников DAOFactory имплементировать абстрактные методы.
 * Для нас это означает: какой бы режим получения данных мы не установили (properties, сервер, offline data base,
 * облачное хранилище и т.д.) нам необходимо позаботиться о том, чтобы наш слой данных вернул нам обработчик
 * ResumeContent и обработчик PassportData. Если лаконично выразить задачу абстрактного блока get методов, то будет
 * звучать так: Обязать слой данных создать обработчики указанных сущностей нашего приложения с указанном в интерфейсе
 * функционалом.
 *
 * Статический метод getDAOFactory(int accessMode) создает для нас экземпляр класса, содержащий в себе обработчики
 * востребованных нами сущностей. В нашем примере PropertiesFileDAOFactory(), по сути, просто знает названия классов
 * обработчиков и занимается их созданием и возвратом. Допустим, если бы у нас в качестве источника еще был бы
 * предусмотрена база данных, то при вызове getDAOFactory(DAOFactory.FROM_DATA_BASE) слой вернул бы нам экземпляр класса
 * DataBaseDAOFactory, содержащий обработчики сущностей, заполняемых из базы данных.
 */
public abstract class DAOFactory {
    public static final int FROM_PROPERTIES_FILE = 1;

    public abstract SeekerDescriptionHandler getSeekerDescriptionHandler();

    public static DAOFactory getDAOFactory(int accessMode) {
        switch(accessMode) {
            case (FROM_PROPERTIES_FILE): {
                return new PropertiesFileDAOFactory();
            }
            default: return null;
        }

    }
}
