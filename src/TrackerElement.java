// the element interface (defines how to accept a visitor).
// all trackable items must implement this interface.
interface TrackerElement {
    // allows the visitor to perform an operation on this element.
    int accept(TrackerVisitor visitor);

    // returns a string with element details.
    String getDetails();
}