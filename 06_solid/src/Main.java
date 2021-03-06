import controllers.EngineImpl;
import controllers.InputParser;
import factories.LoggerFactory;
import intefaces.Engine;
import intefaces.Factory;
import intefaces.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final Factory<Logger> LOGGER_FACTORY = new LoggerFactory();
    private static Engine engine;

    public static void main(String[] args) throws IOException {

        InputParser inputParser = new InputParser();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Main.engine = new EngineImpl(
                Main.LOGGER_FACTORY.produce(inputParser.readLoggerInfo(reader))
        );

        engine.run("END", reader);
        System.out.println(engine.toString());
    }
}
