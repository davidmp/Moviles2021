package pe.edu.upeu.appmultiselect

interface SelectionCompleteListener {
    fun onCompleteSelection(selectedItems: ArrayList<SearchableItem>)
}