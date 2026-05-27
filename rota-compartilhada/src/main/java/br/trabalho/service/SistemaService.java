package br.trabalho.service;

public class SistemaService {

    private MotoristaService motoristaService;
    private PassageiroService passageiroService;
    private CaronasService caronaService;

    public SistemaService(){
        motoristaService = new MotoristaService();
        passageiroService = new PassageiroService();
        caronaService = new CaronasService(motoristaService, passageiroService);
    }

    public MotoristaService getMotoristaService() {
        return motoristaService;
    }

    public PassageiroService getPassageiroService() {
        return passageiroService;
    }

    public CaronasService getCaronaService() {
        return caronaService;
    }
}