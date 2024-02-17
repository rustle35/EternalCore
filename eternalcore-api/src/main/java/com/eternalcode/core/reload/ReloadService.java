package com.eternalcode.core.reload;

public interface ReloadService {

    <T extends Reloadable> T register(T reloadable);

    void reload();

}
