package ayp2.clase12.binaryTree;

public class ItemNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * Construct this exception object.
     */
    public ItemNotFoundException( )
    {
        super( );
    }
    /**
     * Construct this exception object.
     * @param message the error message.
     */
    public ItemNotFoundException (String message )
    {
        super( message );
    }

}
