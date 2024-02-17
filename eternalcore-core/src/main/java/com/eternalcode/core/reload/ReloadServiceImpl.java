package com.eternalcode.core.reload;

import com.eternalcode.core.injector.annotations.component.Service;
import java.util.HashSet;
import java.util.Set;

@Service
class ReloadServiceImpl implements ReloadService {

    private final Set<Reloadable> reloadables = new HashSet<>();

    @Override
    public <T extends Reloadable> T register(T reloadable) {
        this.reloadables.add(reloadable);
        return reloadable;
    }

    @Override
    public void reload() {
        for (Reloadable reloadable : this.reloadables) {
            reloadable.reload();
        }
    }

}
