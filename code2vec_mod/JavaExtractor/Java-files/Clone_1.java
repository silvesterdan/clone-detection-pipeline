public static BufferedImage scale (BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
    BufferedImage dbi = null;
    if (sbi != null) {
        dbi = new BufferedImage (dWidth, dHeight, imageType);
        Graphics2D g = dbi.createGraphics ();
        AffineTransform at = AffineTransform.getScaleInstance (fWidth, fHeight);
        g.drawRenderedImage (sbi, at);
    }
    return dbi;
}


 public static BufferedImage scale (BufferedImage sbi, int imageType, int dWidth, int dHeight, double fWidth, double fHeight){
    if (sbi != null) {
        BufferedImage scaledImg = new BufferedImage(dWidth, dHeight, imageType);
        AffineTransform at = new AffineTransform();
        at.scale(fWidth, fHeight);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BICUBIC);
        scaledImg = scaleOp.filter(sbi, null);
        return scaledImg;
    }
    else {
        return null;
    }
}


