package co.com.bancolombia.model.data.gateways;

import co.com.bancolombia.model.data.Datafile;

public interface DatafileRepository {
    Datafile saveDatafile(Datafile datafile);
}
