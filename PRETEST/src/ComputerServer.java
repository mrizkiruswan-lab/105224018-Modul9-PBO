class ComputerServer {
    private String namaServer;

    // KOMPOSISI
    //harddisk menjadi bagian permanen dari ComputerServer
    private Harddisk harddisk;

    // AGREGASI
    //monitor dapat berdiri sendiri di luar ComputerServer
    private Monitor[] monitors;

    public ComputerServer(String namaServer, String merkHarddisk,int kapasitasHarddisk, Monitor[] monitors) {

        this.namaServer = namaServer;

        //object Harddisk dibuat di dalam class
        //sehingga termasuk komposisi
        this.harddisk = new Harddisk(merkHarddisk, kapasitasHarddisk);

        //monitor diberikan dari luar
        //sehingga termasuk agregasi
        this.monitors = monitors;
    }
}