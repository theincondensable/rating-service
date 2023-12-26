package io.incondensable.business.services.assets;

import io.incondensable.business.models.assets.Provider;
import io.incondensable.business.repositories.ProviderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author abbas
 */
@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

}
