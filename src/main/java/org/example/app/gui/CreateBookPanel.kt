package org.example.app.gui

import java.awt.*
import java.awt.event.ActionEvent
import javax.swing.*

class CreateBookPanel : JPanel() {

    private var formListener: BookFormListener? = null
    init {
        background = Color.RED

        layout = GridBagLayout()
        val formLabel = JLabel("Add Book")
        formLabel.font = Font("Serif", Font.PLAIN, 30)
        val gc = GridBagConstraints()
        gc.gridx = 0
        gc.gridy = 0
        gc.weighty = 1.0 //gives a weight to distribute the cells
        add(formLabel, gc)
        gc.gridy++
        gc.weighty = 1.5
        gc.anchor = GridBagConstraints.NORTH
        add(createFormPanel(), gc)
    }
    fun setFormListener(formListener: BookFormListener) {
        this.formListener = formListener
    }
    private fun createFormPanel(): JPanel {
        val panel = JPanel()
        val padding = 20
        val etchedBorder = BorderFactory.createEtchedBorder()
        val emptyBorder = BorderFactory.createEmptyBorder(padding, padding, padding, padding)
        panel.border = BorderFactory.createCompoundBorder(etchedBorder, emptyBorder)
        val authorLabel = JLabel("Author:")
        val bookTitleLabel = JLabel("Title:")
        val authorField = JTextField(15)
        val bookTitleField = JTextField(15)
        val addButton = JButton("Save")
        addButton.addActionListener { e: ActionEvent? ->
            val author = authorField.text
            val bookTitle = bookTitleField.text

            formListener?.formSubmitted(author, bookTitle)

        }
        val rightPad = Insets(0, 0, 0, 10)
        val zeroInsets = Insets(0, 0, 0, 0)
        val gc = GridBagConstraints()
        panel.layout = GridBagLayout()
        gc.gridwidth = 1
        gc.gridy++
        gc.gridx = 0
        gc.weighty = 0.1
        gc.anchor = GridBagConstraints.LINE_END
        gc.insets = rightPad
        panel.add(authorLabel, gc)
        gc.gridx++
        gc.weighty = 0.1
        gc.anchor = GridBagConstraints.LINE_START
        gc.insets = zeroInsets
        panel.add(authorField, gc)
        gc.gridx = 0
        gc.gridy++
        gc.weighty = 0.1
        gc.anchor = GridBagConstraints.LINE_END
        gc.insets = rightPad
        panel.add(bookTitleLabel, gc)
        gc.gridx++
        gc.weighty = 0.1
        gc.anchor = GridBagConstraints.LINE_START
        gc.insets = zeroInsets
        panel.add(bookTitleField, gc)
        gc.gridy++
        gc.weighty = 30.0
        gc.anchor = GridBagConstraints.FIRST_LINE_END
        panel.add(addButton, gc)
        return panel
    }
}