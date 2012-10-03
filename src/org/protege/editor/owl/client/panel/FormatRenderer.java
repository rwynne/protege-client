package org.protege.editor.owl.client.panel;

import java.text.DateFormat;
import java.text.Format;

import javax.swing.table.DefaultTableCellRenderer;

import org.protege.editor.core.ProtegeApplication;

public class FormatRenderer extends DefaultTableCellRenderer {

	private static final long serialVersionUID = -5210230827997957826L;
	private Format formatter;

	/*
	 *   Use the specified formatter to format the Object
	 */
	public FormatRenderer(Format formatter) {
		this.formatter = formatter;
	}

	public void setValue(Object value) {
		//  Format the Object before setting its value in the renderer
		try {
			if (value != null) {
				value = formatter.format(value);
			}
		}
		catch(IllegalArgumentException e) {
			ProtegeApplication.getErrorLog().logError(e);
		}

		super.setValue(value);
	}

	/*
	 *  Use the default date/time formatter for the default locale
	 */
	public static FormatRenderer getDateTimeRenderer() {
		return new FormatRenderer(DateFormat.getDateTimeInstance());
	}

	/*
	 *  Use the default time formatter for the default locale
	 */
	public static FormatRenderer getTimeRenderer() {
		return new FormatRenderer(DateFormat.getTimeInstance());
	}
}
