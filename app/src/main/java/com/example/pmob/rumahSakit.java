package com.example.pmob;

public class rumahSakit {
    private String imageRS,namaRs,ketRS,noTelp,alamatRS;
    private Double latTujuan,lonTujuan;

    public String getImageRS() {
        return imageRS;
    }

    public String getNamaRs() {
        return namaRs;
    }

    public String getKetRS() {
        return ketRS;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getAlamatRS() {
        return alamatRS;
    }

    public Double getlatTujuan(){return latTujuan;}

    public Double getlonTujuan(){return lonTujuan;}

    public void setAmbilLagi(String a){
        if (a == "RSKIA PKU Muhammad"){
            setDataRs(1);
        }

        if (a == "RSKIA Permata Bunda"){
            setDataRs(2);
        }

        if (a == "RSUD Kota Yogyakarta"){
            setDataRs(3);
        }

        if (a == "RS Pratama Kota Yogyakarta"){
            setDataRs(4);
        }

        if (a == "RS PKU Muhammadiyah"){
            setDataRs(5);
        }

        if (a == "RSI Hidayatullah"){
            setDataRs(6);
        }

        if (a == "Rumah Sakit Umum Veteran Patmasuri"){
            setDataRs(7);
        }

        if (a == "Rumah Sakit Bethesda Yogyakarta"){
            setDataRs(8);
        }

        if (a == "Rumah Sakit Mata Dr. Yap Yogyakarta"){
            setDataRs(9);
        }
    }

    public void setDataRs(int a){
        if(a == 1){
            setDataRS("RSKIA PKU Muhammadiyah");
        }

        if(a == 2){
            setDataRS("RSKIA Permata Bunda");
        }

        if(a == 3){
            setDataRS("RSUD Kota Yogyakarta");
        }

        if(a == 4){
            setDataRS("RS Pratama Kota Yogyakarta");
        }

        if(a == 5){
            setDataRS("RS PKU Muhammadiyah");
        }

        if(a == 6){
            setDataRS("RSI Hidayatullah");
        }

        if(a == 7){
            setDataRS("Rumah Sakit Umum Veteran Patmasuri");
        }

        if(a == 8){
            setDataRS("Rumah Sakit Bethesda Yogyakarta");
        }

        if(a == 9){
            setDataRS("Rumah Sakit Mata Dr. Yap Yogyakarta");
        }
    }

    public void setDataRS(String b) {
        if(b.equals("RSKIA PKU Muhammadiyah")){
            imageRS = "rskiapkumu";
            namaRs = "RSKIA PKU Muhammadiyah";
            ketRS = "fasilitas : \n1. polibedah\n2. fisioterapi\n3. poli kandungan\n4. poli anak\n5 layanan imuniasasi dasar";
            noTelp = "0274371201";
            alamatRS = "rskiapku muhammadiyah jln kemasan no 30 purbayan kec kotagede kota yogyakarta daerah istimewa yogyakarta_55173";
            latTujuan = -7.82207208993476;
            lonTujuan = 110.40096251777855;
        }

        if(b.equals("RSKIA Permata Bunda")){
            imageRS = "rskiapermatabunda";
            namaRs = "RSKIA Permata Bunda";
            ketRS = "fasilitas :\n1. igd anak dan dewasa 23 jam\n2. persalinan 24 jam\n3. fisioterapi bayi dan dewasa\n4. laboratorium klinik 24 jam\n5. home care pasien";
            noTelp = "0274376092";
            alamatRS = "Jl. Ngeksigondo No.56, Prenggan, Kec. Kotagede, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55172";
            latTujuan = -7.819627436398321;
            lonTujuan = 110.39970125640075;
        }

        if(b.equals("RSUD Kota Yogyakarta")){
            imageRS = "rsudkotajogja";
            namaRs = "RSUD Kota Yogyakarta";
            ketRS = "fasilitas :\n1. gawat darurat\n2. rawat inap\n3. rawat jalan\n4. radiologi\n5. farmasi\n6. laboratorium\n7. hemodialisa\n8. kemoterapi";
            noTelp = "0274371195";
            alamatRS = "Jl. Ki Ageng Pemanahan No.1-6, Sorosutan, Kec. Umbulharjo, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55162";
            latTujuan = -7.825487584403438 ;
            lonTujuan = 110.37783489502367;
        }

        if(b.equals("RS Pratama Kota Yogyakarta")){
            imageRS = "rspratama";
            namaRs = "RS Pratama Kota Yogyakarta";
            ketRS = "fasilitas :\n1. igd\2. dokter\n3. rawat inap\n4. rawat inap\n5. rawat jalan\n6. farmasi 24 jam";
            noTelp = "0274373249";
            alamatRS = "Karanganyar, Jl. Kolonel Sugiyono No.98, Brontokusuman, Kec. Mergangsan, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55153.";
            latTujuan = -7.814877525424626;
            lonTujuan = 110.3738628410558;
        }

        if(b.equals("RS PKU Muhammadiyah")){
            imageRS = "rspkumuhammadiyah";
            namaRs = "RS PKU Muhammadiyah";
            ketRS = "fasilitas :\n1. Evakuasi Medis \n2. farmasi 24 jam\n3. Ambulans\n4. radiologi\n5. Bpjs kesehatan\n6. laboratorium";
            noTelp = "0274512653";
            alamatRS = "Jl. KH. Ahmad Dahlan No.20, Ngupasan, Kec. Gondomanan, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55122.";
            latTujuan = -7.800338464729965;
            lonTujuan = 110.36303027217961;
        }
        if(b.equals("RSI Hidayatullah")){
            imageRS = "rsihidayah";
            namaRs = "RSI Hidayatullah";
            ketRS = "fasilitas :\n1. Spesialis Anak\n2. Spesialis Bedah umum\n3. spesialis orthopedi\n4. spesialis penyakit dalam\n5. fisioterapi\n6. gizi";
            noTelp = "0274389194";
            alamatRS = "Jl. Veteran No.184, Pandeyan, Kec. Umbulharjo, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55161.";
            latTujuan = -7.8144790745463215;
            lonTujuan = 110.38775515640016;
        }

        if(b.equals("Rumah Sakit Umum Veteran Patmasuri")){
            imageRS = "veteran";
            namaRs = "Rumah Sakit Umum Veteran Patmasuri";
            ketRS = "fasilitas :\n1. psikiater";
            noTelp = " - ";
            alamatRS = "5995+XWX, Jl. Lapangan Krapyak, Panggungharjo, Sewon, Krapyak Kulon, Panggungharjo, Bantul, Kabupaten Bantul, Daerah Istimewa Yogyakarta 55188.";
            latTujuan = -7.829463811413566;
            lonTujuan = 110.35991377174606;
        }

        if(b.equals("Rumah Sakit Bethesda Yogyakarta")){
            imageRS = "bethesda";
            namaRs = "Rumah Sakit Bethesda Yogyakarta";
            ketRS = "fasilitas :\n1. Kardiologi\n2. IGD dan trauma\n3. stroke center";
            noTelp = "0274586688";
            alamatRS = "Jl. Jend. Sudirman No.70, Kotabaru, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55224.";
            latTujuan = -7.783479671018837;
            lonTujuan = 110.37760482570808;
        }
        if(b.equals("Rumah Sakit Mata Dr. Yap Yogyakarta")) {
            imageRS = "rsmata";
            namaRs = "Rumah Sakit Mata Dr. Yap Yogyakarta";
            ketRS = "fasilitas :\n1. KLINIK AMARTA\n2. MUSEUM\n3. TAMAN\n4. MUSHOLA";
            noTelp = "0274562054";
            alamatRS = "Jl. Cik Di Tiro No.5, Terban, Kec. Gondokusuman, Kota Yogyakarta, Daerah Istimewa Yogyakarta 55223.";
            latTujuan = -7.779937304730552;
            lonTujuan = 110.37469934898576;
        }
    }
}
