
package pprogramming3assignmentone;

/**
 *
 * @author Adam Charlton
 */
public class Welcome extends javax.swing.JPanel {

    /**
     * Creates new form Welcome
     */
    public Welcome() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        analyzercsv = new javax.swing.JLabel();
        guide = new javax.swing.JLabel();
        features = new javax.swing.JLabel();
        sorting = new javax.swing.JLabel();
        overview = new javax.swing.JLabel();
        search = new javax.swing.JLabel();
        statistics = new javax.swing.JLabel();
        trends = new javax.swing.JLabel();
        description = new javax.swing.JLabel();
        csvfound = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(391, 291));

        analyzercsv.setFont(analyzercsv.getFont().deriveFont(analyzercsv.getFont().getStyle() | java.awt.Font.BOLD, analyzercsv.getFont().getSize()+11));
        analyzercsv.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        analyzercsv.setText("Analyzer CSV 1.0");

        guide.setFont(guide.getFont().deriveFont(guide.getFont().getSize()+2f));
        guide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        guide.setText(" CLICK ATTACH TO ADD A FILE");

        features.setFont(features.getFont().deriveFont(features.getFont().getStyle() | java.awt.Font.BOLD, features.getFont().getSize()+3));
        features.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        features.setText("SPECIFIC FEATURES :");

        sorting.setFont(sorting.getFont().deriveFont((sorting.getFont().getStyle() | java.awt.Font.ITALIC), sorting.getFont().getSize()+1));
        sorting.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sorting.setText("DATA SORTING");
        sorting.setPreferredSize(new java.awt.Dimension(0, 25));

        overview.setFont(overview.getFont().deriveFont((overview.getFont().getStyle() | java.awt.Font.ITALIC), overview.getFont().getSize()+1));
        overview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        overview.setText("DATA OVERVIEW");
        overview.setPreferredSize(new java.awt.Dimension(0, 25));

        search.setFont(search.getFont().deriveFont((search.getFont().getStyle() | java.awt.Font.ITALIC), search.getFont().getSize()+1));
        search.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        search.setText("DATA SEARCH");
        search.setPreferredSize(new java.awt.Dimension(0, 25));

        statistics.setFont(statistics.getFont().deriveFont((statistics.getFont().getStyle() | java.awt.Font.ITALIC), statistics.getFont().getSize()+1));
        statistics.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statistics.setText("DATA STATISTICS");
        statistics.setPreferredSize(new java.awt.Dimension(0, 25));

        trends.setFont(trends.getFont().deriveFont((trends.getFont().getStyle() | java.awt.Font.ITALIC), trends.getFont().getSize()+1));
        trends.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        trends.setText("DATA TRENDS");
        trends.setPreferredSize(new java.awt.Dimension(0, 25));

        description.setFont(description.getFont().deriveFont(description.getFont().getSize()+3f));
        description.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        description.setText("Analyzer CSV 1.0 is analysis software to view data from a csv file in a human readable format");

        csvfound.setFont(csvfound.getFont().deriveFont((csvfound.getFont().getStyle() | java.awt.Font.ITALIC) | java.awt.Font.BOLD, csvfound.getFont().getSize()+3));
        csvfound.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        csvfound.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pprogramming3assignmentone/icons/cancel.png"))); // NOI18N
        csvfound.setText("NO CSV FILE FOUND");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(analyzercsv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(features, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sorting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(overview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statistics, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(description, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
            .addComponent(trends, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(csvfound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(analyzercsv, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(features, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(overview, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sorting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(trends, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(guide, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                    .addComponent(csvfound, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel analyzercsv;
    public static javax.swing.JLabel csvfound;
    private javax.swing.JLabel description;
    private javax.swing.JLabel features;
    public static javax.swing.JLabel guide;
    private javax.swing.JLabel overview;
    private javax.swing.JLabel search;
    private javax.swing.JLabel sorting;
    private javax.swing.JLabel statistics;
    private javax.swing.JLabel trends;
    // End of variables declaration//GEN-END:variables
}
