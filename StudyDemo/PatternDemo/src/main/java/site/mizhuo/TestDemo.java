package site.mizhuo;

import org.junit.Test;
import site.mizhuo.designpattern.adapter.DockingStation;
import site.mizhuo.designpattern.bridge.DriverManager;
import site.mizhuo.designpattern.bridge.MyDriverManager;
import site.mizhuo.designpattern.bridge.MysqlDriver;
import site.mizhuo.designpattern.bridge.OracleDriver;
import site.mizhuo.designpattern.builder.Meal;
import site.mizhuo.designpattern.builder.MealBuilder;
import site.mizhuo.designpattern.chain.AbstractLogger;
import site.mizhuo.designpattern.chain.ConsoleLogger;
import site.mizhuo.designpattern.chain.ErrorLogger;
import site.mizhuo.designpattern.chain.FileLogger;
import site.mizhuo.designpattern.command.Command;
import site.mizhuo.designpattern.command.Commander;
import site.mizhuo.designpattern.command.MilitaryOrder;
import site.mizhuo.designpattern.command.Soldier;
import site.mizhuo.designpattern.composite.Area;
import site.mizhuo.designpattern.decorator.*;
import site.mizhuo.designpattern.facade.Computer;
import site.mizhuo.designpattern.factory.*;
import site.mizhuo.designpattern.filter.*;
import site.mizhuo.designpattern.filter.ApplePhone;
import site.mizhuo.designpattern.filter.HuaWeiPhone;
import site.mizhuo.designpattern.flyweight.ConnectionPool;
import site.mizhuo.designpattern.interpreter.Context;
import site.mizhuo.designpattern.interpreter.Expression;
import site.mizhuo.designpattern.interpreter.Minus;
import site.mizhuo.designpattern.interpreter.Plus;
import site.mizhuo.designpattern.iterator.Collection;
import site.mizhuo.designpattern.iterator.Iterator;
import site.mizhuo.designpattern.iterator.MyCollection;
import site.mizhuo.designpattern.mediator.User;
import site.mizhuo.designpattern.memento.Archive;
import site.mizhuo.designpattern.memento.ArchiveTaker;
import site.mizhuo.designpattern.observer.*;
import site.mizhuo.designpattern.prototype.MobileCache;
import site.mizhuo.designpattern.proxy.MySelfRentHouse;
import site.mizhuo.designpattern.proxy.ProxyRentHouse;
import site.mizhuo.designpattern.proxy.RentHouse;
import site.mizhuo.designpattern.singleton.Singleton2;
import site.mizhuo.designpattern.state.State;
import site.mizhuo.designpattern.state.StateA;
import site.mizhuo.designpattern.state.StateB;
import site.mizhuo.designpattern.templete.Chrome;
import site.mizhuo.designpattern.templete.Chromium;
import site.mizhuo.designpattern.templete.Edge;
import site.mizhuo.designpattern.visitor.BusinessReport;
import site.mizhuo.designpattern.visitor.CEOVisitor;
import site.mizhuo.designpattern.visitor.CTOVisitor;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestDemo
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-08-23 22:17
 * @Version 1.0
 **/
public class TestDemo {
    @Test
    public void test1(){
        MethodFactory factory = new HuaWeiPhoneFactory();
        Mobile mobile = factory.producationMobile();
        mobile.mobileInfo();
    }

    @Test
    public void test2(){
        AbstractFactory factory = new XiaoMiPhoneFactory();
        Mobile mobile = factory.producationMobile();
        mobile.mobileInfo();
    }

    @Test
    public void test3(){
        Singleton2 instance = Singleton2.getInstance();
        System.out.println(instance);
    }

    @Test
    public void test4(){
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepareVegMeal();
        System.out.println("????????????:");
        meal.showItems();
        System.out.println("??????:" + meal.getCost());
        System.out.println("????????????:");
        Meal meal2 = mealBuilder.prepareChickenMeal();
        meal2.showItems();
        System.out.println("??????:" + meal2.getCost());
    }

    @Test
    public void test5(){
        MobileCache.loadCache();

        site.mizhuo.designpattern.prototype.Mobile mobile1 = MobileCache.getMobile("apple");
        System.out.println(mobile1);

        site.mizhuo.designpattern.prototype.Mobile  mobile2 = MobileCache.getMobile("huawei");
        System.out.println(mobile2);

        site.mizhuo.designpattern.prototype.Mobile  mobile3 = MobileCache.getMobile("xiaomi");
        System.out.println(mobile3);

    }

    @Test
    public void test6(){
        DockingStation dock = new DockingStation();
        dock.function("typeC-E","220V");
        dock.function("typeC-T","????????????");
        dock.function("hdmi","LG?????????");
    }

    @Test
    public void test7(){
        DriverManager manager = new MyDriverManager(new MysqlDriver());
        manager.connectDB();
        DriverManager manager2 = new MyDriverManager(new OracleDriver());
        manager2.connectDB();
    }

    @Test
    public void test8(){
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("Apple","iphone12 mini",5999.00));
        phones.add(new Phone("Apple","iphone12",6999.00));
        phones.add(new Phone("Apple","iphone12 Pro Max",9999.00));
        phones.add(new Phone("HuaWei","P40",5699.00));
        phones.add(new Phone("HuaWei","Mate40",7999.00));
        phones.add(new Phone("HuaWei","Mate40 Pro",9999.00));
        phones.add(new Phone("XiaoMi","Mix4",9999.00));

        CriteriaPhones p1 = new ApplePhone();
        CriteriaPhones p2 = new HuaWeiPhone();
        CriteriaPhones p3 = new HighEndPhones();
        CriteriaPhones p4 = new MultipleConditionAnd(p1,p3);
        CriteriaPhones p5 = new MultipleConditionOr(p2,p3);

        System.out.println("p1:" + p1.filterPhones(phones));
        phones.stream().filter(p-> "Apple".equalsIgnoreCase(p.getBrand())).forEach(System.out::println);
        System.out.println("--------------------------");
        System.out.println("p2:" +p2.filterPhones(phones));
        phones.stream().filter(p-> "HuaWei".equalsIgnoreCase(p.getBrand())).forEach(System.out::println);
        System.out.println("--------------------------");
        System.out.println("p3:" +p3.filterPhones(phones));
        phones.stream().filter(p-> p.getPrice() > 8888).forEach(System.out::println);
        System.out.println("--------------------------");
        System.out.println("p4:" +p4.filterPhones(phones));
        phones.stream().filter(p-> "Apple".equalsIgnoreCase(p.getBrand())).filter(p -> p.getPrice() > 8888).forEach(System.out::println);
        System.out.println("--------------------------");
        System.out.println("p5:" +p5.filterPhones(phones));
        phones.stream().filter(p-> "HuaWei".equalsIgnoreCase(p.getBrand()) || p.getPrice() > 8888).forEach(System.out::println);
    }

    @Test
    public void test9(){
        Area china = new Area("??????");
        Area beijing = new Area("??????");
        Area zhejiang = new Area("??????");
        Area hangzhou = new Area("??????");
        Area chaoyang = new Area("?????????");
        Area dongcheng = new Area("?????????");
        beijing.add(chaoyang);
        beijing.add(dongcheng);
        zhejiang.add(hangzhou);
        china.add(beijing);
        china.add(zhejiang);
        System.out.println(china.toString());
    }

    @Test
    public void test10(){
        Animal animal = new Monkey();
        AnimalWithSoul animal1 = new ImmortalAnimal(new Monkey());
        AnimalWithSoul animal2 = new ImmortalAnimal(new Pig());

        animal.abilities();
        animal1.abilities();
        animal2.abilities();
    }

    @Test
    public void test11(){
        Computer computer = new Computer();
        computer.startUp();
        System.out.println("???????????????...");
        computer.shutDown();
    }

    @Test
    public void test12(){
        ConnectionPool connectionPool = new ConnectionPool();
        for(int i = 0;i < 25;i++) {
            Connection connection = connectionPool.getConnection();
            System.out.println(connection);
        }
    }

    @Test
    public void test13(){
        RentHouse rentHouse = new MySelfRentHouse("mizhuo");
        rentHouse.findHouse();
        rentHouse.rentHouse();
        RentHouse house = new ProxyRentHouse("??????","mizhuo");
        house.rentHouse();
    }

    private static AbstractLogger chain(){
        AbstractLogger logger1 = new ConsoleLogger(AbstractLogger.DEBUG);
        AbstractLogger logger2 = new FileLogger(AbstractLogger.INFO);
        AbstractLogger logger3 = new ErrorLogger(AbstractLogger.ERROR);

        logger3.setNextLogger(logger1);
        logger1.setNextLogger(logger2);
        return logger3;
    }

    @Test
    public void test14(){
        AbstractLogger chain = chain();
        chain.log(AbstractLogger.INFO,"This is an information!");
        chain.log(AbstractLogger.DEBUG,"This is a debug level information!");
        chain.log(AbstractLogger.ERROR,"This is an error information!");
    }

    @Test
    public void test115(){
        Soldier soldier = new Soldier();
        Command command = new MilitaryOrder(soldier);
        Commander commander = new Commander(command);
        commander.pushCommand();
    }

    @Test
    public void test16(){
        Context context = new Context();
        context.setNum1(20);
        context.setNum2(10);
        Expression expression = new Plus();
        System.out.println(expression.interpreter(context));
        Expression expression2 = new Minus();
        System.out.println(expression2.interpreter(context));
    }

    @Test
    public void test17(){
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    @Test
    public void test18(){
        User user = new User("mizhuo");
        user.sendMessage("??????????????????????????????");

        User user2 = new User("miao");
        user2.sendMessage("????????????????????????????????????");
    }

    @Test
    public void test19(){
        Archive archive = new Archive();
        ArchiveTaker taker = new ArchiveTaker();
        archive.setStatus("??????1");
        archive.setStatus("??????2");
        taker.add(archive.saveArchive());
        archive.setStatus("??????3");
        taker.add(archive.saveArchive());
        archive.setStatus("??????4");
        System.out.println("???????????????:" + archive.getStatus());
        System.out.println("?????????????????????");
        archive.getStatusFromArchive(taker.getGame(0));
        System.out.println("???????????????:" + archive.getStatus());
        System.out.println("?????????????????????");
        archive.getStatusFromArchive(taker.getGame(1));
        System.out.println("???????????????:" + archive.getStatus());
    }

    @Test
    public void test20(){
        Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        new HexObserver(subject);

        System.out.println("?????????????????????13");
        subject.setState(13);
        System.out.println("?????????????????????24");
        subject.setState(24);
    }

    @Test
    public void test21(){
        site.mizhuo.designpattern.strategy.Context context = new site.mizhuo.designpattern.strategy.Context(new site.mizhuo.designpattern.strategy.Plus());
        System.out.println(context.executeOptions("2+8"));
        site.mizhuo.designpattern.strategy.Context context2 = new site.mizhuo.designpattern.strategy.Context(new site.mizhuo.designpattern.strategy.Minus());
        System.out.println(context2.executeOptions("2-8"));
        site.mizhuo.designpattern.strategy.Context context3 = new site.mizhuo.designpattern.strategy.Context(new site.mizhuo.designpattern.strategy.Multiply());
        System.out.println(context3.executeOptions("2*8"));
    }

    @Test
    public void test22(){
        Chromium browser = new Chrome();
        browser.useBrowser();
        browser = new Edge();
        browser.useBrowser();
    }

    @Test
    public void test23(){
        site.mizhuo.designpattern.state.Context context = new site.mizhuo.designpattern.state.Context();
        State state = new StateA();
        state.doAction(context);
        state = new StateB();
        state.doAction(context);
    }

    @Test
    public void test24(){
        BusinessReport report = new BusinessReport();
        System.out.println("=========== CEO????????? ===========");
        report.showReport(new CEOVisitor());
        System.out.println("=========== CTO????????? ===========");
        report.showReport(new CTOVisitor());
    }
}
