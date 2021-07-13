package in.achuala.core.charges.resource;

import dagger.Component;
import in.achuala.core.charges.config.CacheModule;

import javax.inject.Singleton;

@Singleton
@Component(modules = CacheModule.class)
public interface ResourceFactory {
    TransactionResource createTransactionResource();
    ChargesResource createChargesResource();
    ChargesAdminResource createChargesAdminResource();
}
