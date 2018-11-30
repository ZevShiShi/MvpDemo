package zhu.zev.com.demo.di.component;

import dagger.Component;
import zhu.zev.com.demo.MainActivity;
import zhu.zev.com.demo.di.module.UserModule;

/**
 * Created by zev on 2018/11/30.
 */
@Component(modules = UserModule.class)
public interface UserComponent {
    MainActivity inject(MainActivity mainActivity);
}
