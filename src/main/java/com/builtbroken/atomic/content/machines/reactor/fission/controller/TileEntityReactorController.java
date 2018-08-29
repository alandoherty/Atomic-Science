package com.builtbroken.atomic.content.machines.reactor.fission.controller;

import com.builtbroken.atomic.content.machines.TileEntityMachine;
import com.builtbroken.atomic.content.machines.reactor.fission.core.TileEntityReactorCell;
import net.minecraft.tileentity.TileEntity;

import java.util.ArrayList;

/**
 * Block used to relay data and control to a reactor stack
 *
 * @see <a href="https://github.com/BuiltBrokenModding/VoltzEngine/blob/development/license.md">License</a> for what you can and can't do with the code.
 * Created by Dark(DarkGuardsman, Robert) on 6/18/2018.
 */
public class TileEntityReactorController extends TileEntityMachine
{
    /** Unique id of the reactor stack, used by display systems */
    public String stackID;
    /** Display name of the reactor stack, used by display systems */
    public String stackName;

    // Array of reactor cells in the connected stack
    private TileEntityReactorCell[] cells;

    // Is the CPU in an error state, can be caused by too many CPUs in a stack
    private boolean inErrorState = false;

    //Trigger to refresh the cells array
    private boolean refreshStack = true;

    //Trigger to enable reactor cores
    private boolean enableReactors = true;

    @Override
    protected void update(int ticks)
    {
        if(isServer())
        {
            if (cells == null || refreshStack || ticks % 20 == 0) //TODO remove tick refresh after testing
            {
                doRefreshStack();
            }

            if(ticks % 3 == 0)
            {
                TileEntityReactorCell[] cells = getReactorCells();
                if(cells != null)
                {
                    for(TileEntityReactorCell cell : cells)
                    {
                        cell.enabled = enableReactors;
                    }
                }
            }
        }
    }

    protected void doRefreshStack() //TODO have reactors trigger this when placed
    {
        inErrorState = false;
        refreshStack = false;
        cells = null;

        ArrayList<TileEntityReactorCell> reactorCellList = new ArrayList();

        for (int y = yCoord + 1; y < 255; y++)
        {
            TileEntity tileEntity = worldObj.getTileEntity(xi(), y, zi());
            if (tileEntity instanceof TileEntityReactorCell)
            {
                reactorCellList.add((TileEntityReactorCell) tileEntity);
            }
            else if (tileEntity instanceof TileEntityReactorController)
            {
                inErrorState = true; //TODO maybe use a message instead of a boolean for more detail?
                return;
            }
            else
            {
                break;
            }
        }

        for (int y = yCoord - 1; y > 0; y--)
        {
            TileEntity tileEntity = worldObj.getTileEntity(xi(), y, zi());
            if (tileEntity instanceof TileEntityReactorCell)
            {
                reactorCellList.add((TileEntityReactorCell) tileEntity);
            }
            else if (tileEntity instanceof TileEntityReactorController)
            {
                inErrorState = true; //TODO maybe use a message instead of a boolean for more detail?
                return;
            }
            else
            {
                break;
            }
        }

        cells = (TileEntityReactorCell[]) reactorCellList.toArray();
    }

    public boolean isInErrorState()
    {
        return inErrorState;
    }

    public TileEntityReactorCell[] getReactorCells()
    {
        return cells;
    }

    public void markForRefresh()
    {
        refreshStack = true;
    }

    public int getCellCount()
    {
        return getReactorCells() != null ? getReactorCells().length : 0;
    }
}