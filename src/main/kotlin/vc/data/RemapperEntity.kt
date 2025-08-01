/*
 *     The Certora Prover
 *     Copyright (C) 2025  Certora Ltd.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, version 3 of the License.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package vc.data

import com.certora.collect.*
import utils.*

interface RemapperEntity<T> : UniqueIdEntity<T>, ExtensionGetter where T: java.io.Serializable, T : UniqueIdEntity<T> {
    override fun mapId(f: (Any, Int, () -> Int) -> Int): T {
        return this.getExtensionMethod("Remapper").invoke(null, this, f).uncheckedAs<T>()
    }
}
