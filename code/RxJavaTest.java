import rx.Scheduler;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import java.util.Observable;
import java.util.concurrent.TimeUnit;

public class RxJavaTest {

    public static void main(String args[]){
        testCountDown();
    }

    private static void testCountDown(){
        rx.Observable.timer(2,TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        System.out.print(aLong);
                    }
                });
    }
}
