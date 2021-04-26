public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=====================================================");
        System.out.println("\tProgram Pendukung Keputusan Beasiswa");
        System.out.println("\t\tMenggunakan Metode AHP");
        System.out.println("=====================================================");

        Kriteria objKriteria = new Kriteria("IPK", 1, "K1");
        Kriteria objKriteria2 = new Kriteria("Jumlah Penghasilan Orang Tua", 2, "K2");
        Kriteria objKriteria3 = new Kriteria("Jumlah Tanggungan Orang Tua", 3, "K3");
        Kriteria objKriteria4 = new Kriteria("Semester", 4, "K4");
        int jumlahKriteria = 4;
        objKriteria.show();
        objKriteria2.show();
        objKriteria3.show();    
        objKriteria4.show();
        

        PB perbandinganMatriks = new PB();
        
        double[][] perbMatriksInput = new double[jumlahKriteria][jumlahKriteria];
        
        perbMatriksInput[0][0] = 1;
        perbMatriksInput[0][1] = 3;
        perbMatriksInput[0][2] = 5;
        perbMatriksInput[0][3] = 7;
        
        perbMatriksInput[1][0] = 0.333;
        perbMatriksInput[1][1] = 1;
        perbMatriksInput[1][2] = 3;
        perbMatriksInput[1][3] = 5;
        
        perbMatriksInput[2][0] = 0.2;
        perbMatriksInput[2][1] = 0.333;
        perbMatriksInput[2][2] = 1;
        perbMatriksInput[2][3] = 5;
        
        perbMatriksInput[3][0] = 0.143;
        perbMatriksInput[3][1] = 0.2;
        perbMatriksInput[3][2] = 0.2;
        perbMatriksInput[3][3] = 1;

        
        System.out.println("\nMatriks yang di-Input : ");
        perbandinganMatriks.display(perbMatriksInput);
    
        
        SubKriteria sub = new SubKriteria(perbMatriksInput);
        
        System.out.println("\nJumlah dari masing-masing Kolom : ");
        double[] jumlahkolom = sub.calcJumlahKolom();
        sub.display(jumlahkolom);

        
        System.out.println("\nSubKriteria Matriks : ");
        double[][] matriksnormalisasi = sub.normMatriks(jumlahkolom);
        perbandinganMatriks.display(matriksnormalisasi);
        
        
        System.out.println("\nJumlah dari masing-masing Baris : ");
        double[] jumlahbaris = sub.calcJumlahBaris(matriksnormalisasi);
        sub.display(jumlahbaris);
        
        
        System.out.println("\nPrioritasnya adalah : ");
        double[] prioritas = sub.calcPrioritas(jumlahbaris);
        sub.display(prioritas);
        
        
        System.out.println("\nMatriks Penjumlahan setiap Baris adalah : ");
        double[][] matrikspenjumlahanbaris = sub.calcMatriksPenjumlahanBaris(prioritas);
        perbandinganMatriks.display(matrikspenjumlahanbaris);
        
        
        System.out.println("\nJumlah Baris dari Matriks Penjumlahan setiap Baris adalah : ");
        double[] jumlahmatrikspnjmlhbaris = sub.calcJumlahBaris(matrikspenjumlahanbaris);
        sub.display(jumlahmatrikspnjmlhbaris);
        
        System.out.println("\nmax prioritas");
        double nilaiMaks = sub.nilaiMaxPrior(prioritas);
        
        System.out.println("Nilai Sub Kriteria ");
        double[] hitungSubKriteria = sub.subPrioritas(prioritas, nilaiMaks);
        sub.display(hitungSubKriteria);

        System.out.println("\nPerbandingan Rasio Konsistensi : ");
        double[] perrasiokonsistensi = sub.calcPerbandinganRasio(jumlahmatrikspnjmlhbaris,prioritas);
        sub.display(perrasiokonsistensi);

        System.out.println("\nKonsistensi Rasio adalah : ");
        sub.display();
        sub.Konsistensi();


        System.out.println("\n======================================");
        System.out.println("\tData Penerima Beasiswa");
        System.out.println("======================================");
        
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Nama    | IPK        | Jlh Penghasilan OrangTua  | Jlh Tanggungan OrangTua   | Semester");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Aceng\t    4.00\t< 1.500.000\t\t\t 3\t\t\t6");
        System.out.println("Mahmud\t  3.00-3.50\t> 3.000.000\t\t\t<=2\t\t\t5");
        System.out.println("Jamal\t  3.00-3.50\t< 1.500.000\t\t\t<=3\t\t\t4");

        
        
        
    }
    
}