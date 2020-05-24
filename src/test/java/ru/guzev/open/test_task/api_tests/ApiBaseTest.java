package ru.guzev.open.test_task.api_tests;

import org.aeonbits.owner.ConfigFactory;
import ru.guzev.open.test_task.config.SystemConfig;

public abstract class ApiBaseTest {

    protected SystemConfig cfg = ConfigFactory.create(SystemConfig.class);

}
