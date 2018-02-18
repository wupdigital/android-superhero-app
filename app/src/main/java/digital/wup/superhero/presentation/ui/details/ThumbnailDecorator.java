package digital.wup.superhero.presentation.ui.details;


import digital.wup.superhero.data.model.Image;

public class ThumbnailDecorator extends Image {
    private static final String IMG_VARIANT = "portrait_uncanny";

    public ThumbnailDecorator(Image image) {
        setExtension("." + image.getExtension());
        setPath(image.getPath() + "/" + IMG_VARIANT);
    }
}
