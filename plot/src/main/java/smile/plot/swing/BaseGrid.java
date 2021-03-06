/*******************************************************************************
 * Copyright (c) 2010-2019 Haifeng Li
 *
 * Smile is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * Smile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Smile.  If not, see <https://www.gnu.org/licenses/>.
 *******************************************************************************/

package smile.plot.swing;

/**
 * The grid in the base coordinate space.
 *
 * @author Haifeng Li
 */
class BaseGrid {

    /**
     * The base coordinate space.
     */
    private Base base;
    /**
     * The axis objects.
     */
    private Axis[] axis;

    /**
     * Constructor.
     */
    public BaseGrid(Base base) {
        this.base = base;
        axis = new Axis[base.getDimension()];
        for (int i = 0; i < base.getDimension(); i++) {
            axis[i] = new Axis(base, i);
        }
    }

    /**
     * Constructor.
     */
    public BaseGrid(Base base, String... axisLabels) {
        if (axisLabels.length != base.getDimension()) {
            throw new IllegalArgumentException("Axis label size don't match base dimension.");
        }

        this.base = base;
        axis = new Axis[base.getDimension()];
        for (int i = 0; i < base.getDimension(); i++) {
            axis[i] = new Axis(base, i, axisLabels[i]);
        }
    }

    /**
     * Set if labels and tickmarks are visible.
     */
    public BaseGrid setLabelVisible(int i, boolean v) {
        axis[i].setLabelVisible(v);
        return this;
    }

    /**
     * Returns if labels and tickmarks are visible.
     */
    public boolean isLabelVisible(int i) {
        return axis[i].isLabelVisible();
    }

    /**
     * Set if the grid visible.
     */
    public BaseGrid setGridVisible(int i, boolean v) {
        axis[i].setGridVisible(v);
        return this;
    }

    /**
     * Returns if the grid visible.
     */
    public boolean isGridVisible(int i) {
        return axis[i].isGridVisible();
    }

    /**
     * Set if the frame visible.
     */
    public BaseGrid setFrameVisible(boolean v) {
        for (int i = 0; i < axis.length; i++) {
            axis[i].setGridVisible(v);
        }
        return this;
    }

    /**
     * Returns if the frame visible.
     */
    public boolean isFrameVisible() {
        return axis[0].isGridVisible();
    }

    /**
     * Returns the axis.
     */
    public Axis getAxis(int i) {
        return axis[i];
    }

    /**
     * Set axis labels.
     */
    public BaseGrid setAxisLabel(String... axisLabels) {
        if (axisLabels.length != base.getDimension()) {
            throw new IllegalArgumentException("Axis label size don't match base dimension.");
        }

        for (int i = 0; i < axisLabels.length; i++) {
            axis[i].setAxisLabel(axisLabels[i]);
        }

        return this;
    }

    /**
     * Get axis label.
     */
    public String[] getAxisLabel() {
        String[] array = new String[axis.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = axis[i].getAxisLabel();
        }
        return array;
    }

    /**
     * Set axis labels.
     */
    public BaseGrid setAxisLabel(int i, String axisLabel) {
        axis[i].setAxisLabel(axisLabel);
        return this;
    }

    /**
     * Get axis label.
     */
    public String getAxisLabel(int i) {
        return axis[i].getAxisLabel();
    }

    /**
     * Set the base coordinate space.
     */
    public BaseGrid setBase(Base base) {
        this.base = base;
        for (int i = 0; i < axis.length; i++) {
            axis[i].setBase(base);
        }
        return this;
    }

    /**
     * Draw the grid.
     */
    public void paint(Graphics g) {
        for (int i = 0; i < axis.length; i++) {
            axis[i].paint(g);
        }
    }
}
