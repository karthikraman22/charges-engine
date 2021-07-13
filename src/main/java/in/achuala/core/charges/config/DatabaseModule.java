package in.achuala.core.charges.config;

import dagger.Module;
import dagger.Provides;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.postgres.PostgresPlugin;

import javax.inject.Singleton;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    Jdbi createJdbi() {
        Jdbi jdbi = Jdbi.create("jdbc:postgresql://localhost:26257/coredb")
                .installPlugin(new PostgresPlugin());
        return jdbi;
    }
}
